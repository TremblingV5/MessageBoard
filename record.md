I have a class marked with `javax.persistence.Entity` which `Springboot` says it not a managed type. And I marked the main class with `@EntityScan`.

This is all the trace info:

```
org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'messageDomainServiceImpl': Unsatisfied dependency expressed through field 'messageRepository': Error creating bean with name 'messageRepositoryImpl' defined in file [D:\Project\Java\MessageBoard\MessageBoard-Message\target\classes\org\demo\message\domain\repository\MessageRepositoryImpl.class]: Unsatisfied dependency expressed through constructor parameter 0: Error creating bean with name 'jpaMessageRepository' defined in org.demo.message.infrastructure.jpa.JpaMessageRepository defined in @EnableJpaRepositories declared on JpaRepositoriesRegistrar.EnableJpaRepositoriesConfiguration: Not a managed type: class org.demo.message.domain.model.Message
	at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor$AutowiredFieldElement.resolveFieldValue(AutowiredAnnotationBeanPostProcessor.java:712) ~[spring-beans-6.0.2.jar:6.0.2]
	at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor$AutowiredFieldElement.inject(AutowiredAnnotationBeanPostProcessor.java:692) ~[spring-beans-6.0.2.jar:6.0.2]
	at org.springframework.beans.factory.annotation.InjectionMetadata.inject(InjectionMetadata.java:127) ~[spring-beans-6.0.2.jar:6.0.2]
	at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor.postProcessProperties(AutowiredAnnotationBeanPostProcessor.java:481) ~[spring-beans-6.0.2.jar:6.0.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.populateBean(AbstractAutowireCapableBeanFactory.java:1397) ~[spring-beans-6.0.2.jar:6.0.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:598) ~[spring-beans-6.0.2.jar:6.0.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:521) ~[spring-beans-6.0.2.jar:6.0.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:326) ~[spring-beans-6.0.2.jar:6.0.2]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234) ~[spring-beans-6.0.2.jar:6.0.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:324) ~[spring-beans-6.0.2.jar:6.0.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:200) ~[spring-beans-6.0.2.jar:6.0.2]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:961) ~[spring-beans-6.0.2.jar:6.0.2]
	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:915) ~[spring-context-6.0.2.jar:6.0.2]
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:584) ~[spring-context-6.0.2.jar:6.0.2]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:730) ~[spring-boot-3.0.0.jar:3.0.0]
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:432) ~[spring-boot-3.0.0.jar:3.0.0]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:308) ~[spring-boot-3.0.0.jar:3.0.0]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1302) ~[spring-boot-3.0.0.jar:3.0.0]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1291) ~[spring-boot-3.0.0.jar:3.0.0]
	at org.demo.message.Message.main(Message.java:19) ~[classes/:na]
Caused by: org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'messageRepositoryImpl' defined in file [D:\Project\Java\MessageBoard\MessageBoard-Message\target\classes\org\demo\message\domain\repository\MessageRepositoryImpl.class]: Unsatisfied dependency expressed through constructor parameter 0: Error creating bean with name 'jpaMessageRepository' defined in org.demo.message.infrastructure.jpa.JpaMessageRepository defined in @EnableJpaRepositories declared on JpaRepositoriesRegistrar.EnableJpaRepositoriesConfiguration: Not a managed type: class org.demo.message.domain.model.Message
	at org.springframework.beans.factory.support.ConstructorResolver.createArgumentArray(ConstructorResolver.java:793) ~[spring-beans-6.0.2.jar:6.0.2]
	at org.springframework.beans.factory.support.ConstructorResolver.autowireConstructor(ConstructorResolver.java:242) ~[spring-beans-6.0.2.jar:6.0.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.autowireConstructor(AbstractAutowireCapableBeanFactory.java:1344) ~[spring-beans-6.0.2.jar:6.0.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1188) ~[spring-beans-6.0.2.jar:6.0.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:561) ~[spring-beans-6.0.2.jar:6.0.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:521) ~[spring-beans-6.0.2.jar:6.0.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:326) ~[spring-beans-6.0.2.jar:6.0.2]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234) ~[spring-beans-6.0.2.jar:6.0.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:324) ~[spring-beans-6.0.2.jar:6.0.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:200) ~[spring-beans-6.0.2.jar:6.0.2]
	at org.springframework.beans.factory.config.DependencyDescriptor.resolveCandidate(DependencyDescriptor.java:254) ~[spring-beans-6.0.2.jar:6.0.2]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.doResolveDependency(DefaultListableBeanFactory.java:1405) ~[spring-beans-6.0.2.jar:6.0.2]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveDependency(DefaultListableBeanFactory.java:1325) ~[spring-beans-6.0.2.jar:6.0.2]
	at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor$AutowiredFieldElement.resolveFieldValue(AutowiredAnnotationBeanPostProcessor.java:709) ~[spring-beans-6.0.2.jar:6.0.2]
	... 19 common frames omitted
Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'jpaMessageRepository' defined in org.demo.message.infrastructure.jpa.JpaMessageRepository defined in @EnableJpaRepositories declared on JpaRepositoriesRegistrar.EnableJpaRepositoriesConfiguration: Not a managed type: class org.demo.message.domain.model.Message
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1751) ~[spring-beans-6.0.2.jar:6.0.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:599) ~[spring-beans-6.0.2.jar:6.0.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:521) ~[spring-beans-6.0.2.jar:6.0.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:326) ~[spring-beans-6.0.2.jar:6.0.2]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234) ~[spring-beans-6.0.2.jar:6.0.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:324) ~[spring-beans-6.0.2.jar:6.0.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:200) ~[spring-beans-6.0.2.jar:6.0.2]
	at org.springframework.beans.factory.config.DependencyDescriptor.resolveCandidate(DependencyDescriptor.java:254) ~[spring-beans-6.0.2.jar:6.0.2]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.doResolveDependency(DefaultListableBeanFactory.java:1405) ~[spring-beans-6.0.2.jar:6.0.2]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveDependency(DefaultListableBeanFactory.java:1325) ~[spring-beans-6.0.2.jar:6.0.2]
	at org.springframework.beans.factory.support.ConstructorResolver.resolveAutowiredArgument(ConstructorResolver.java:880) ~[spring-beans-6.0.2.jar:6.0.2]
	at org.springframework.beans.factory.support.ConstructorResolver.createArgumentArray(ConstructorResolver.java:784) ~[spring-beans-6.0.2.jar:6.0.2]
	... 32 common frames omitted
Caused by: java.lang.IllegalArgumentException: Not a managed type: class org.demo.message.domain.model.Message
	at org.hibernate.metamodel.model.domain.internal.JpaMetamodelImpl.managedType(JpaMetamodelImpl.java:181) ~[hibernate-core-6.1.5.Final.jar:6.1.5.Final]
	at org.hibernate.metamodel.model.domain.internal.MappingMetamodelImpl.managedType(MappingMetamodelImpl.java:496) ~[hibernate-core-6.1.5.Final.jar:6.1.5.Final]
	at org.hibernate.metamodel.model.domain.internal.MappingMetamodelImpl.managedType(MappingMetamodelImpl.java:99) ~[hibernate-core-6.1.5.Final.jar:6.1.5.Final]
	at org.springframework.data.jpa.repository.support.JpaMetamodelEntityInformation.<init>(JpaMetamodelEntityInformation.java:77) ~[spring-data-jpa-3.0.0.jar:3.0.0]
	at org.springframework.data.jpa.repository.support.JpaEntityInformationSupport.getEntityInformation(JpaEntityInformationSupport.java:69) ~[spring-data-jpa-3.0.0.jar:3.0.0]
	at org.springframework.data.jpa.repository.support.JpaRepositoryFactory.getEntityInformation(JpaRepositoryFactory.java:246) ~[spring-data-jpa-3.0.0.jar:3.0.0]
	at org.springframework.data.jpa.repository.support.JpaRepositoryFactory.getTargetRepository(JpaRepositoryFactory.java:211) ~[spring-data-jpa-3.0.0.jar:3.0.0]
	at org.springframework.data.jpa.repository.support.JpaRepositoryFactory.getTargetRepository(JpaRepositoryFactory.java:194) ~[spring-data-jpa-3.0.0.jar:3.0.0]
	at org.springframework.data.jpa.repository.support.JpaRepositoryFactory.getTargetRepository(JpaRepositoryFactory.java:81) ~[spring-data-jpa-3.0.0.jar:3.0.0]
	at org.springframework.data.repository.core.support.RepositoryFactorySupport.getRepository(RepositoryFactorySupport.java:317) ~[spring-data-commons-3.0.0.jar:3.0.0]
	at org.springframework.data.repository.core.support.RepositoryFactoryBeanSupport.lambda$afterPropertiesSet$5(RepositoryFactoryBeanSupport.java:279) ~[spring-data-commons-3.0.0.jar:3.0.0]
	at org.springframework.data.util.Lazy.getNullable(Lazy.java:229) ~[spring-data-commons-3.0.0.jar:3.0.0]
	at org.springframework.data.util.Lazy.get(Lazy.java:113) ~[spring-data-commons-3.0.0.jar:3.0.0]
	at org.springframework.data.repository.core.support.RepositoryFactoryBeanSupport.afterPropertiesSet(RepositoryFactoryBeanSupport.java:285) ~[spring-data-commons-3.0.0.jar:3.0.0]
	at org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean.afterPropertiesSet(JpaRepositoryFactoryBean.java:132) ~[spring-data-jpa-3.0.0.jar:3.0.0]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1797) ~[spring-beans-6.0.2.jar:6.0.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1747) ~[spring-beans-6.0.2.jar:6.0.2]
	... 43 common frames omitted


```

This is directory tree of my project:

```
```
