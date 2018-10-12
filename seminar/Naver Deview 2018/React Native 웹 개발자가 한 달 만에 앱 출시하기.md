## React Native 웹 개발자가 한 달 만에 앱 출시하기

native code --> react native code ; 성능 향상.. ㅠㅠㅠㅠㅠ

[ 장 점 ]

단 기간에 최소 비용으로 앱을 개발하는 데 있어 높은 효율을 보임

android main thread <-->  bridge  <--> javascript thread

bridge ; 확장성과 앱의 저하를 방지

네이티브 호출 마다 직렬화와 역직렬화 때문에 부하 이슈가 생김.

큐를 통새 성능 이슈 개선

native
	event handler
bridge
	call
javascript
	function 