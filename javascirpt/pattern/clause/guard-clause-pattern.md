## Guard Clauses Pattern
가드 패턴이라고도 한다.<br/>
if-else 분기 처리의 가독성을 살려 핵심 로직을 가장 하위로 두는 방식이다. <br/>

```
public async verifyToken(email: string, token: string, purpose: string) {
  const user = await UserService.getUserByEmail(email);

  if(user) {
    const token = await user.getToken({...});
                                       
    if (token) {
      if(token.purpose === 'reset') {
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }
}
```

중첩 조건문 때문에 로직을 파악하기 어렵다. <br/>
실제 중요한 로직이 어느 부분인지 알기 어렵다. <br/>

```
public async verifyToken(email: string, token: string, purpose: string) {
  const user = await UserService.getUserByEmail(email);

  // 아래의 조건문 이후로, user가 존재한다는 것이 보장됩니다.
  if(!user) {
    return false;
  }
  
  const token = await user.getToken({...});                               
  if (!token || token.purpose !== 'reset') {
    return false;
  }
  
  // 여기까지 온 경우, true가 반환되기 위한 조건을 모두 갖췄다고 볼 수 있습니다.
  return true;
}
```

상단에서 하나씩 예외 조건을 처리하기 때문에, 하단에서 중요한 로직에 집중하기 쉬워진다. <br/>
단, 새롭게 조건이 추가 될 경우 코드를 수정해야 한다는 단점이 있다. <br/>

특정 조건에서만 로직을 수행해야 한다면, 가드를 하는 방법보다, if문으로 감싸는게 추후 확장성에서 더 좋은 방법이 될 수도 있다.
```
public async getToken(email: string, token: string, purpose: string) {
  const user = await UserService.getUserByEmail(email);
  // 이후 다른 조건이 추가가 된다고 하더라도 getToken의 조건으로만 동작을 하기 때문에 사이드 이펙트가 발생할 여지가 적다.
  if (user.getToken !== null) {
    const token = user.getToken
    return token;
  }

  return null;
}

public async validToken() {
  const token = await getToken(args)
  // purpose가 reset인 경우에만 true를 반환하도록 한다면 purpose에 다른 타입이 추가되더라도, 코드에 영향을 주지 않는다.
  if (token && token.purpose === 'reset') {
    return true;
  }

  return false
}
```

상황에 따라 if로 감싸는 조건에 주요 로지글 추가 할 지, if로 감싸지지 않은 부분에 주요 로직을 추가할 지 고려해야 한다.