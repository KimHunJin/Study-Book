## Intent vs Intent Filter vs Pending Intent

### Intent

Intent는 메시징 객체로, 다른 앱 구성 요소로부터 작업을 요청하는 데 사용할 수 있습니다. 앱 구성 요소는 Android 앱의 필수적인 기본 구성 요소입니다. 각 구성 요소는 시스템이나 사용자가 앱에 들어올 수 있는 진입점입니다. 다른 구성 요소에 종속되는 구성 요소도 있습니다. 앱 구성 요소에는 네 가지 유형이 있습니다. (액티비티, 서비스 , 브로드 캐스트, 콘텐츠 제공자)

인텐트가 구성 요소 사이의 통신을 촉진하는 데는 여러가지 방식이 있지만 기본적으로 액티비티와 서비스 시작, 브로드캐스트 전달에 사용됩니다.

- 액티비티 시작
    - Intent를 startActivity()로 전달
- 서비스 시작
    - Android 5.0(API 레벨 21) 이상부터는 JobScheduler로 서비스를 시작할 수 있습니다.
    - JobScheduler에 대한 자세한 내용은 [https://developer.android.com/reference/android/app/job/JobScheduler?hl=ko](https://developer.android.com/reference/android/app/job/JobScheduler?hl=ko)
- 브로드캐스트 전달
    - 브로드캐스트는 모든 앱이 수신할 수 있는 메시지입니다. 시스템은 시스템이 부팅될 때 또는 기기가 충전을 시작할 때 등 시스템 이벤트에 대한 다양한 브로드캐스트를 전달합니다. Intent를 sendBroadcast() 또는 sendOrderedBroadcast()에 전달하면 다른 앱에 브로드캐스트를 전달할 수 있습니다.

인텐트에는 두가지 유형이 있습니다.

- 명시적 인텐트
    - 인텐트에 전달되는 클래스 객체 컴포넌트 이름을 정확히 지정하여 호출될 대상을 확실히 알 수 있는 경우. 예를들어 ,
    ```
    var intent = Intent(this@MainActivity, SecondActivity::class.java)
    ``` 

- 암시적 인텐트
    - 인텐트의 액션과 데이터를 지정하긴 했지만, 호출할 대상이 달라질 수 있는 경우에는 암시적인 인텐트를 사용한다. 설치된 애플리케이션들에 대한 정보를 알고있는 안드로이드 시스템이 인텐트를 이용해 요청한 정보를 처리할 수 있는 적절한 컴포넌트를 찾아본다. 그리고 나서 사용자에게 그 대상과 처리 결과를 보여주는 과정을 거친다.
    - 특정 컴포넌트에서 암시적 인텐트를 받기 위해서는 매니페스트 파일에서 요소와 함께 어플리케이션 컴포넌트 각각에 대해서 하나 이상의 IntentFilter를 선언해야한다. 각각의 컴포넌트는 action, data, category를 기반으로 해서 자신이 받길 원하는 인텐트의 유형을 명시해야한다.
    - 암시적 인텐트를 사용하는 대표적인 경우로 문서 편집기를 들 수 있다. 카카오톡으로 PDF 파일을 받아서 열기를 클릭하면 PDF를 편집하거나 보여줄 수 있는 많은 애플리케이션들이 자기가 그 PDF 파일을 열겠다고 손을 든다. 그러면 안드로이드 시스템에서는 PDF를 열 수 있는 애플리케이션을 선택하는 위젯을 띄워준다.

- 암시적 인텐트가 시스템을 통해 전달되어 다른 액티비티를 시작하는 방법.

1. 액티비티 A가 작업 설명이 있는 Intent를 생성하여 이를 startActivity()에 전달.
2. Android 시스템이 모든 앱에서 해당 인텐트와 일치하는 인텐트 필터를 검색 일치하는 항목을 찾으면,
3. 시스템이 해당 액티비티의 onCreate() 메서드를 호출하여 이를 Intent에 전달하고 , 일치하는 액티비티(Activity B)를 시작한다.

암시적 인텐트는 보통 액션과 데이터라는 속성으로 구성되어있다. **액션**은 수행할 기능이며, **데이터**는 액션이 수행될 대상 데이터을 의미한다.

    ```
    var intent = Intent(Intent.ACTION_DIAL, Uri.parse(data))
    ```    

예를 들어, 위의 코드에서 액션은 ACTION_DIAL 즉, 전화를 걸라는 액션. 데이터는 Uri.parse(data), 즉 액션이 수행할 data , 전화번호가 된다. 따라서 Uri로 파싱한 전화번호 data를 대상으로 전화다이얼을 걸어라는 뜻이고 이 뜻을 인텐트에 담아 안드로이드 시스템에게 전달하면 된다.

이 두가지 말고도 Category, Type, Component, Extras라는 속성을 가진다. 여기서 Component라는 속성을 지정할 경우 컴포넌트 클래스 이름을 명시적으로 지정하게 되는데 이 경우가 **명시적 인텐트**에 속하게 된다.



### Intent Filter
앱이 수신할 수 있는 암시적 인텐트가 어느 것인지 알리려면, <intent-filter>요소를 사용하여 각 앱 구성 요소에 대해 하나 이상의 인텐트 필터를 매니페스트 파일에 선언한다. 각 인텐트 필터는 인텐트의 작업, 데이터 및 카테고리를 기반으로 하여 어느 유형의 인텐트를 수락하는지 지정한다. 시스템은 인텐트가 인텐트 필터 중 하나를 통과한 경우에만 암시적 인텐트를 앱 구성 요소에 전달한다.

앱 구성 요소는 자신이 수행할 수 있는 각각의 고유한 작업에 대하여 별도의 필터를 선언해야 한다. 예를 들어 이미지 갤러리 앱에 있는 어떤 액티비티에 두 개의 필터가 있을 수 있다. 한 필터는 이미지를 보고, 다른 필터는 이미지를 편집하기 위한 것이다. 액티비티가 시작되면 , Intent를 검사한 다음 Intent에 있는 정보를 근거로 어떻게 동작할 것인지를 결정.

각 인텐트 필터는 앱의 매니페스트 파일에 있는 <intent-filter> 요소에서 정의하고, 이는 대응되는 앱 구성 요소에 중첩된다. (예 : <activity> 요소)

<intent-filter> 내부에서는 <action>, <data>, <category> 요소를 사용하여 허용할 인텐트 유형을 지정할 수 있다.

- <action>
    - name 특성에서 허용된 인텐트 작업을 선언한다. 이 값은 어떤 작업의 리터럴 문자열 값이어야 하며, 클래스 상수가 아니다.
- <data>
    - 허용된 데이터 유형을 선언. 이때 데이터 URI( scheme, host, port, path) 와 MIME 유형의 여러가지 측면을 나타내는 하나 이상의 특성을 사용.
- <category>
    - name 특성에서 허용된 인텐트 카테고리를 선언. 이 값은 어떤 작업의 리터럴 문자열 값이어야 하며, 클래스 상수가 아니다.

예) ACTION_SEND 인텐트를 수신할 수 있는 인텐트 필터
    ```
    <activity android:name="ShareActivity">
        <intent-filter>
            <action android:name="android.intent.action.SEND"/>
            <category android:name="android.intent.category.DEFAULT"/>
            <data android:mimeType="text/plain"/>
        </intent-filter>
    </activity>
    ```    

**IntentFilter를 동적으로 등록할 수 도 있습니다.** IntentFilter를 매니페스트 파일에 등록하지 않고 코드에서 동적으로 등록할 수 있습니다.

예제) MMS 메시지 도착 이벤트를 받는 브로드캐스트 리시버를 동적 등록할 때
    ```
    public class ChattingRoomActivity extends AppCompatActivity {
    	private MMSReceiver mReceiver;
    	protected void onCreate(Bundle savedInstancestate){
    		…
    		registMMSReceiver();
    }
    	…
    	private void registMMSReceiver(){
    		mReceiver = new MMSReceiver();
    		/* 인텐트필터 생성 */    
    		IntentFilter intentFilter = new IntentFilter();
    		intentFilter.addAction(“android.provider.Telephony.WAP_PUSH_
    RECEIVED”);
    intentFilter.addDataType(“application/vnd.wap.mms-message”);
    /* 브로드캐스트 리시버에 인텐트 필터를 달아준다. */
    this.registerReceiver(mReceiver, intentFilter, Manifest.permission.
    BROADCAST_WAP_PUSH, null);
    	}
    	
    	@Override
    	protected void onDestroy(){
    		super.onDestroy();
    		this.unregisterReceiver(mReceiver);
    	}
    }
    ```

### Pending Intent

    PendingIntent 객체는 Intent 객체 주변을 감싸는 래퍼이다. 외부 애플리케이션에 권한을 허가하여 안에 들어 있는 Intent를 마치 본인 앱의 자체 프로세스에서 실행하는 것처럼 사용하게 하는 것이 목적.

예) 지정된 시간에 인텐트가 실행되도록 선언 ( Android 시스템의 AlarmManager가 Intent를 실행)

- 일반 인텐트와 차이점?
    - 컴포넌트에서 다른 컴포넌트에게 작업을 요청하는 인텐트를 사전에 생성시키고 만든다는 점과 “특정 시점”에 자신이 아닌 다른 컴포넌트들이 펜딩인텐트를 사용하여 다른 컴포넌트에게 작업을 요청시키는 데 사용된다는 점이 차이점이다.

***“A한테 이 B 인텐트를 C시점에 실행하라고 해. 지금 말고. “***

각 Intent 객체는 특정한 유형의 앱 구성 요소 ( Activity, Service 또는 BroadcastReceiver)가 처리하도록 설계되어 있으므로, PendingIntent도 같은 고려사항을 생각해서 생성해야 한다. PendingIntent를 생성할 때 원래 의도한 구성 요소 유형을 선언해야 한다.

- Activity를 시작하는 Intent의 경우, PendingIntent.getActivity()
- Service를 시작하는 Intent의 경우, PendingIntent.getService()
- BroadcastReceiver를 시작하는 Intent의 경우, PendingIntent.getBroadcast()

앱이 다른 앱에서 PendingIntent를 수신하지 않는 한, 위의 PendingIntent를 생성하는 메서드만 있으면 된다. 각 메서드는 현재 앱의 Context, 감싸고자 하는 Intent, 인텐트의 적절한 사용 방식을 나타내는 하나 이상의 플래그(예: 인텐트를 한번 이상 사용할 수 있는 지 여부) 등을 취한다.

여기에 적절한 예제와 자세한 설명이 있다. ([https://techlog.gurucat.net/80](https://techlog.gurucat.net/80))
