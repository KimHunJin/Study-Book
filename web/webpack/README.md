# Webpack

### # Webpack이란?
- modern javascript를 위한 정적 모듈 번들러
- 모듈 시스템을 지원하지 않는 브라우저 (IE 등)을 지원 해준다.
* (4.0 이상부터는 configure file을 필요로 하지 않는다.)

webpack.config.js

```    
const path = require('path');
    
module.exports = {
    mode: 'development',
    entry: {
        main: './src/app.js'
    },
    output: { // 결과물
        filename: '[name].js',
        path: path.resolve('./dist'),
    },
}
```

entry에서 어떤 내용을 빌드 할 지 결정하며, <br/>
그 내용은 output에 결과물로 제공된다.


### # Entry
엔트리포인트는 내부 dependency graph 작성을 위해 사용해야 하는 module webpack이다.<br/>
webpack은 엔트리포인트가 의존하는 다른 module이나 library를 파악한다.


### # Dependency Graph
한 파일이 다른 파일에 의존할 때 webpack은 이것을 의존성으로 취급한다.<br/>
이로 인해 webpack은 이미지나 폰트 같은 non-code assets을 가져와 애플리케이션의 종속성을 제공한다. <br/>

webpack이 application 처리 할 때 command line 혹은 설정 파일에서 정의된 모듈 리스트로부터 시작한다.<br/>
이 Entry Point에서 시작할 때 웹팩은 application에 필요한 모든 모듈을 포함하는 dependency graph를 재귀적으로 빌드한다.<br/>
이후, 브라우저에서 로드할 수 있게 적은 수의 bundle로 모든 module을 묶는다.<br/>

> bundling은 application에 새 요청을 시작하는 동안 앱이 대기하는 횟수를 최소화 하기에 HTTP 1.1에서 특히 강력하다.<br/>
> HTTP2에서는 code splitting을 사용하여 최상의 결과를 얻을 수 있다.

### # Code Splitting
code splitting은 webpack의 가장 강력한 기능 중 하나다.<br/>
이 기능을 사용하면, 코드를 다양한 bundle로 분할하여 요청하거나 병렬로 로드할 수 있다.<br/>
더 작은 번들로 달성하고, 올바르게 사용한다면, 우선순위대로 자원을 제어하여 로드하는 시간에 큰 영향을 미칠 수 있다.<br/>

일반적으로 code splitting에는 3가지 방식이 있다.
  * Entry Points: 엔트리 설정을 통해 코드를 수동으로 분리한다.
  * 중복 방지 : SplitChunksPlugin을 사용해 dedupe와 정크 파일을 분리할 수 있다.
  * Dynamic Import : module 내에서 inline 함수를 호출 해 코드를 분할한다.


### # Loader

```
const path = require('path');
        
module.exports = {
    mode: 'development',
    entry: {
        main: './src/app.js'
    },
    output: {
        filename: '[name].js',
        path: path.resolve('./dist'),
    },
    module: {
        rules: [{
            test: /\.css$/,   // style-loader를 앞에 추가한다 (css가 style보다 먼저 렌더 되야 하기때문)
            use: ['style-loader', 'css-loader'],
        }]
    }
}
```

웹팩은 여러가지 모듈을 사용하여 규칙을 정할 수 있다.

규칙이란, 오른쪽에서 왼쪽으로 변환 되는 형식을 의미한다.

위 코드에서는 css파일을 style 파일로 변환시키는 작업을 한다.


