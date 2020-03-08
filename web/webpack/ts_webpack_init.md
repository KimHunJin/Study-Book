# TypeScript와 Webpack으로 React를 초기 세팅 해보자

1. create directory // 폴더 생성
2. npm init -y // npm 세팅
3. npm install
4. npm install --save-dev webpack webpack-cli // webpack 설치
    (주의, webpack을 설치하지 않으면, npx 실행 시점에서 오류 발생)
5. npm install --save-dev typescript ts-loader // typescript, ts-loader 설치
6. tsconfig.json 생성
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
7. webpack.config.js 파일 생성
```
const path = require('path');

module.exports = {
  entry: './src/index.ts',
  devtool: 'inline-source-map',
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
8. 실행
```
npx webpack --config ./webpack.config.js
```
