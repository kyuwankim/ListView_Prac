# ListView_Prac
ListView
--
스크롤 가능한 항목의 목록을 표시하는 뷰 그룹입니다. 목록 항목은 배열 또는 데이터베이스 쿼리와 같은 소스에서 콘턴츠를 가져와서 목록에 배치된 뷰로 각 항목 결과를 변환하는 adapter를 사용하여 목록에 자동으로 삽입됩니다.


![ListView](https://developer.android.com/images/ui/listview.png?hl=ko)

리스트뷰 사용단계
--
1. ListView 위젯 가져오기
2. Adapter 정의하기
3. ListView 에 Adapter 세팅하기


>Adapter
>
>ListView에 데이터를 추가하여 화면에 표시하기 위해서는 Adapter를 사용해야 합니다. 일반적으로 "어댑터"라는 의미는 "장치 또는 기계의 다른 부분을 연결하는 장치로, 적합하지 않은 두 개의 부분을 전기적 또는 기계적으로 접속하기 위한 장치 또는 도구"를 말합니다. ListView에서 사용하는 Adapter 또한 의미적으로 크게 다르지 않습니다. 유사한 문장으로 표현하자면 "사용자가 정의한 데이터를 ListView에 출력하기 위해 사용하는 객체로, 사용자 데이터와 화면 출력 View로 이루어진 두 개의 부분을 이어주는 객체" 정도가 되겠네요. 즉, Adapter가 하는 역할은 사용자 데이터를 입력받아 View를 생성하는 것이며 Adapter에서 생성되는 View는 ListView 내 하나의 아이템 영역에 표시되는 것입니다.


<pre>CustomAdapter.java
<code>
      public class CustomAdapter extends BaseAdapter {

    LayoutInflater inflater;
    String datas[];

    public CustomAdapter(String[] datas, Context context) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.length;
    }

    @Override
    public Object getItem(int position) {
        return datas[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null) { // 한번 화면에 세팅됬던 행은 convertView 에 담겨져서 돌아온다.
            convertView = inflater.inflate(R.layout.list_item, null);
        }

        TextView tv = (TextView) convertView.findViewById(R.id.textView);
        tv.setText(datas[position]);

        return convertView;
    }
}
</code>
</pre>


*Adapter를 불러올 때 생성자를 설정하면서 inflater를 만들어준다*

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);





<pre>MainActivity.java
<code>
public class MainActivity extends AppCompatActivity {

    ListView listview;

    String array[] = {"a","b","c","d","e","f","g","f","g","f","g","f","g","f","g","f","g","f","g"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (ListView) findViewById(R.id.listview);

        CustomAdapter adapter = new CustomAdapter(array, this);

        listview.setAdapter(adapter);

    }
}
</code>
</pre>

선택위젯
--
안드로이드에서 특별히 여러 개의 아이템을 선택할 수 있는 위젯들을 '선택 위젯'이라고 부른다. 다른 위젯과 다르게 특별히 이름을 붙이는 이유는 사용되는 방식이 기존 위젯과는 사뭇 다르기 때문이다. 선택 위젯은 어댑터(Adapter) 패턴을 사용하므로 직접 위젯의 각 아이템에 이미지나 텍스트를 넣을 수 없을 뿐더러, 어댑터에서 만들어주는 뷰를 이용해 리스트 뷰의 한 아이템을 보여줘야한다. 

**ListView의 경우 Adapter를 통해서 inflate를 하는데 화면에서 각 선택위젯이 사라질때마다 계속 재생성을 하기때문에 비효율이 발생함 이것을 막기위해 ViewHolder라는 개념이 생겼고 *RecyclerView* 에서 사용할 수 있음**


#Recycler View
-
RecyclerView 위젯은 ListView의 더욱 향상되고 유연해진 버전입니다. 이 위젯은 한정된 수의 뷰를 유지함으로써 매우 효율적으로 스크롤할 수 있는 큰 데이터 집합을 표시하기 위한 컨테이너입니다. 사용자 작업 또는 네트워크 이벤트에 따라 런타임에 요소가 변경되는 데이터 컬렉션이 있는 경우 RecyclerView 위젯을 사용하세요.

![RecyclerView](https://developer.android.com/training/material/images/RecyclerView.png?hl=ko)


레이아웃 관리자는 항목 뷰를 RecyclerView 내에 배치하고 사용자에게 더 이상 보이지 않는 항목 뷰를 언제 재사용할지 결정합니다. 뷰를 재사용 (또는 재활용)하기 위해, 레이아웃 관리자는 어댑터에게 뷰의 콘텐츠를 데이터 집합의 다른 요소로 교체하도록 요청할 수 있습니다. 이런 방식으로 뷰를 재활용하면 불필요한 뷰 생성이나 리소스를 많이 소모하는 findViewById() 조회를 수행하지 않아도 되므로 성능이 개선됩니다.

