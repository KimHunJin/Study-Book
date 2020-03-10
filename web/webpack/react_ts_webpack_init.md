### npm install 초기 설정

```
1. npm install --save-dev webpack webpack-cli ts-loader typescript source-map-loader @types/react @types/react-dom
2. npm install --save react react-dom
```

### tsconfig 설정
```
{
  "compilerOptions": {
    "outDir": "./dist/", // 결과를 저장할 경로
    "noImplicitAny": true, // 타입 검사 활성화
    "module": "ES6", // 사용할 모듈 설정
    "target": "ES5", // 사용할 ECMAScript 버전 설정
    "jsx": "react", // jsx 지원
    "allowJs": true, // js 허용
    "removeComments": true, // 주석 삭제
    "preserveConstEnums": true, // const enum 선언 제거 여부
    "sourceMap": true // 소스맵 (*.map) 파일 생성 여부
  }
}
```

### webpack.config.js 설정

```
const path = require('path');

module.exports = {
    entry: {
        app: path.join(__dirname, 'src', 'index.tsx')
    },
    mode: 'development',
    devtool: 'source-map',
    module: {
        rules: [
            {
                test: /\.ts(x?)$/,
                use: 'ts-loader',
                exclude: /node_modules/,
            },
            {
                enforce: 'pre',
                test: /\.js$/,
                loader: 'source-map-loader'
            }
        ],
    },
    resolve: {
        extensions: ['.ts', '.tsx'],
    },
    externals: {
        'react': 'React',
        'react-dom': 'ReactDOM'
    },
    output: {
        filename: 'bundle.js',
        path: path.resolve(__dirname, 'dist')
    }
}
```

### package.json 설정
```
{
  "name": "webpack-study",
  "version": "1.0.0",
  "description": "",
  "main": "index.js",
  "scripts": {
    "test": "echo \"Error: no test specified\" && exit 1",
    "build": "webpack --config ./webpack.config.js"
  },
  "author": "mos",
  "license": "ISC",
  "devDependencies": {
    "@types/react": "^16.9.23",
    "@types/react-dom": "^16.9.5",
    "source-map-loader": "^0.2.4",
    "ts-loader": "^6.2.1",
    "typescript": "^3.8.3",
    "webpack": "^4.42.0",
    "webpack-cli": "^3.3.11"
  },
  "dependencies": {
    "react": "^16.13.0",
    "react-dom": "^16.13.0"
  }
}

```

### /dist/index.html 생성
```
<!DOCTYPE HTML>
<html>
<head>
    <title>Getting Started</title>
    <script src="https://unpkg.com/lodash@4.16.6"></script>
</head>
<body>
<div id="root"/>
<script src="./node_modules/react/umd/react.development.js"></script>
<script src="./node_modules/react-dom/umd/react-dom.development.js"></script>
<script src="./src/index.js"></script>
</body>
</html>
```

### /src/index.tsx 생성

```
import * as React from "react";
import * as ReactDom from "react-dom";

import {Hello} from "./components/Hello";

ReactDom.render(
    <Hello name="모기" age={27}/>,
    document.getElementById("root")
);
```

### /src/components/Hello.tsx 생성

```
import * as React from 'react';

interface Props {
    name: string;
    age: number;
}

export const Hello = (props: Props): React.ReactElement => (
    <h1>My name is ${props.name} and I'm ${props.age} years old</h1>
);
```


### 실행
```
npm run build
```

### 결과 (/dist/bundle.js)
```
"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Hello", function() { return Hello; });
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! react */ "react");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(react__WEBPACK_IMPORTED_MODULE_0__);

var Hello = function (props) { return (react__WEBPACK_IMPORTED_MODULE_0__["createElement"]("h1", null,
    "My name is $",
    props.name,
    " and I'm $",
    props.age,
    " years old")); };
```
