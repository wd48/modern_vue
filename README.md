# modern_vue
- https://github.com/wikibook/spring-vuejs
  - 실전! 모던 웹 애플리케이션 개발 : 예제 코드 파일

## Ch2
- 밀접하게 연결되어 있는 컴포넌트들의 이름에 대한 지침
  - '부모 컴포넌트와 밀접하게 연결된 자식 컴포넌트는 부모 컴포넌트의 이름을 접두사로 포함해야 한다'

### Local error
- from origin 'null' has been blocked by CORS policy: Cross origin requests are only supported for protocol schemes: http, data, chrome, chrome-extension, chrome-untrusted, https. [link](https://velog.io/@takeknowledge/%EB%A1%9C%EC%BB%AC%EC%97%90%EC%84%9C-CORS-policy-%EA%B4%80%EB%A0%A8-%EC%97%90%EB%9F%AC%EA%B0%80-%EB%B0%9C%EC%83%9D%ED%95%98%EB%8A%94-%EC%9D%B4%EC%9C%A0-3gk4gyhreu)
```
npm install http-server -g
npm http-server
나온 목록 중 하나 선택해서 접속
```
***
> SOP (Same Origin Policy : 동일 출처 정책)   
> : 어떤 출처 (origin)에서 불러온 문서나 스크립트가 다른 출처에서 가져온 리소스와 상호작용하는 것을 제한하는 브라우저의 보안 방식
