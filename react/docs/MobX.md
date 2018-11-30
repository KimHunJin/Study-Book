# MobX

> 4가지 주요 개념을 가지고 있다.


1. Observable State (관찰 받고 잇는 상태)
    * 앱의 상태가 Observable State (관찰 받고 있는 상태)
    * 변화된 부분을 감지
    
2. Computed Value (연산된 값)
    * 기존 상태 값과 다른 연산된 값에 기반하여 만들어질 수 있는 값.
    * 바뀐 값
    
3. Reactions (반응)
    * Computed Value는 연산해야 될 때에만 처리되지만, Reactions는 값이 바뀔 때 해야 할 일임.
    * ex) Observable State의 내부 값이 바뀔 때 console.log() 호출
    
4. Actions (액션; 행동)
    * 상태에 변화를 일으키는 것.
    
    
## autorun
> 자동으로 그 값을 주시하여 그 값이 바뀔 때 마다 함수가 주시되도록 해줌. <br/>
> 하나하나 observe 해주지 않아도 됨.


## Redux vs MobX

옵션 | Redux | MobX
----|--------|------
불변성 | 유지 | 신경X
함수형 | O | O
