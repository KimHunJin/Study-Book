# Webpack

### Webpack이란?
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

entry에서 어떤 내용을 빌드 할 지 결정하며,

그 내용은 output에 결과물로 제공된다.

### Loader

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
