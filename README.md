# Logback 환경설정을 외부 환경변수에 따라 분기해서 적용하기

스프링부트를 쓰면, logback-spring.xml 파일을 만들고 이 안에서 spring.profiles.active 환경변수에 따라서 로깅 설정을 분기해서 적용하는 기능이 있다.

하지만 상황에 따라서는 스프링부트 없이 일반 Spring WebMVC만을 사용해서 프로젝트를 진행할때도 있을법도 한데 ~~요즘 그런 프로젝트가 얼마나 있겠냐마는~~ , 스프링부트 없이도 해당 기능을 흉내낼 수 없을까 싶어서 관련 정보를 찾아보고 실제로 작성해 보았다.

이번에는 일단 예제로서, activeEnv라는 JVM 환경변수에 따라서 로깅 설정이 분기하도록 짜 봤다.

activeEnv가 local인 경우에는 모든 로그를 콘솔로 출력함과 동시에, /logs/local 경로에 로그를 저장한다.

activeEnv가 dev인 경우에는 로그를 콘솔로 출력하지는 않고, 대신 /logs/dev 경로에 로그를 저장한다.

## references

* [Logback에 spring profile을 적용하기](https://oingdaddy.tistory.com/16) : 위 설정을 해보려고 인터넷 문서를 이것저것 찾아봐서 실험해보고 있었는데, 마지막에 나온 이 문서가 그냥 정답이었다. 
* [Does logback have a NullAppender?](https://stackoverflow.com/questions/17610574) : Logback에 NullAppender는 없냐는 스택오버플로 질문. 답변자는, NOPAppender가 있다고 답변해준다.
* [Read environment variables from logback configuration file](https://stackoverflow.com/a/23969706) : Logback에서 환경변수를 읽어오는 방법이 없느냐는 질문. 답변자는 janino를 사용하는 대신, 개발자가 직접 사용자 Logback Context Listener를 만들어서 Logback에 등록하는 방법을 제시한다.
* [how to define logback variables/properties before logback auto-load logback.xml?](https://stackoverflow.com/a/24235375) : Logback에서 사용자 변수는 어떻게 생성하고 사용하냐는 질문. 답변자는 <property> 태그를 제시한다. 처음에는 이 문제를 해결하기 위해서 위의 사용자 ContextListener와 <property> 태그로 해결하려고 했었다.
* [Logback configuration | Conditional processing of configuration files](https://logback.qos.ch/manual/configuration.html#conditional) : Logback 환경설정을 조건별로 적용되도록 설정하는 방법. 공식문서는 일단 이런데, 이번에는 거의 읽어보지 않았다.
* 