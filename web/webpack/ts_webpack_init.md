# TypeScript와 Webpack으로 React를 초기 세팅 해보자

1. create directory // 폴더 생성
2. npm init -y // npm 세팅
3. npm install
4. npm install --save-dev webpack webpack-cli // webpack 설치
    (주의, webpack을 설치하지 않으면, npx 실행 시점에서 오류 발생)
5. npm install --save-dev typescript ts-loader // typescript, ts-loader 설치
6. npm install --save lodash
7. npm install --save-dev @types/lodash
8. tsconfig.json 생성
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

9. webpack.config.js 파일 생성
```
const path = require('path');

module.exports = {
  entry: './src/index.ts',
  devtool: 'inline-source-map',
  mode: 'development',
  module: {
    rules: [
      {
        test: /\.tsx?$/,
        use: 'ts-loader',
        exclude: /node_modules/,
      },
    ],
  },
  resolve: {
    extensions: [ '.tsx', '.ts', '.js' ],
  },
  output: {
    filename: 'bundle.js',
    path: path.resolve(__dirname, 'dist'),
  },
};

```

10. 초기 세팅 (/src/index.ts)
```
function component() {
  const element = document.createElement('div');

  element.innerHTML = _.join(['안녕', '웹팩'], ' ');
  return element;
}

document.body.appendChild(component());
```

11. 초기 세팅 (/dist/index.html)
```
<!doctype html>
<html>
  <head>
    <title>Getting Started</title>
    <script src="https://unpkg.com/lodash@4.16.6"></script>
  </head>
  <body>
    <script src="./src/index.js"></script>
  </body>
</html>
```

12. 실행
```
npx webpack --config ./webpack.config.js
```
/dist 폴더에 bundle.js 라는 파일이 생김.
'안녕' 으로 검색을 해 보면 웹팩을 통한 결과가 어떻게 구성됐는지 확인할 수 있음.

13. 결과
```
/***/ "./src/index.ts":
/*!**********************!*\
  !*** ./src/index.ts ***!
  \**********************/
/*! no exports provided */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var lodash__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! lodash */ "./node_modules/lodash/lodash.js");
/* harmony import */ var lodash__WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(lodash__WEBPACK_IMPORTED_MODULE_0__);

function component() {
    var element = document.createElement('div');
    element.innerHTML = lodash__WEBPACK_IMPORTED_MODULE_0__["join"](['안녕', '웹팩'], ' ');
    return element;
}
document.body.appendChild(component());
```
