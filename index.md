[![Maven Status](https://maven-badges.herokuapp.com/maven-central/io.github.hadiljr/jdata-forger/badge.svg?style=flat)](http://mvnrepository.com/artifact/io.github.hadiljr/jdata-forger)
[![Build Status](https://www.travis-ci.com/hadiljr/jdata-forger.svg?branch=master)](https://www.travis-ci.com/hadiljr/jdata-forger)
[![Coverage Status](https://coveralls.io/repos/github/hadiljr/jdata-forger/badge.svg?branch=master)](https://coveralls.io/github/hadiljr/jdata-forger?branch=master)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

Esta biblioteca gera dados falsos. Util para seeds de projetos em desenvolvimento.

Utilização
----------

### Maven
No arquivo pom.xml, adicionar a nova dependencia entre as tags `<dependencies> ... </dependencies>`

```xml
<dependency>
    <groupId>io.github.hadiljr</groupId>
    <artifactId>jdata-forger</artifactId>
    <version>0.2</version>
</dependency>
```

### Gradle

No arquivo build.gradle, adicionar a nova dependencia

```groovy
dependencies {
    implementation 'io.github.hadiljr:jdata-forger:0.2'
}
```

### No Seu Código Java

```java
Forger forger = new Forger();

String cpf = forger.CPF().fake(); // 700.779.240-53
```

Geradores de Dados Na Versão 
-----
* CPF 

# Café ?

[![ko-fi](https://ko-fi.com/img/githubbutton_sm.svg)](https://ko-fi.com/W7W34GREL)

![Coffee](assets/images/CoffeQR.png "Logo Title Text 1")