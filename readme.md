# belajar spring framework

## IoC [Inversion Of Control]

```
prinsip dalam pembuatan perangkat lunak, dimana kita melakukan pemindahan control untuk object atau program ke sebuah container dalam framework.
memliki control:
- eksekusi program
- management object
- melakukan abstraction
- code program harus mengikuti cara kerja framework

spring merupakan sebuah framework IoC.
goods news nya karena harus mengikuti cara bekerja framework, setiap engineer bisa satu irama dalam membuat code program.
container IoC spring adalah aplication context
```

## Aplication Context

```
merupakan sebuah interface representasi container IoC di spring.
untuk membuat aplication cntext perlu membuat configuration class dengan anotasi @Configuration.
setelah membuat configuration class kita bisa menggunakan class AnnotationConfigApplicationContext untuk membuat Aplication Context.
```

## Singleton

```
- class bersifat private agar tidak bisa diakses dari luar
```

## Bean

```
object yang dimasukan ke dalam spring container, dan bean adalah singleton.
nama method dalam class configuration, dan nama method merupakan bean nya dan menggunakan anotasi @Bean
untuk mengakses bean menggunakan method getBean
```

## Duplicate Bean

```
- di spring, kita bisa mendaftarkan beberapa bean dengan tipe yang sama
- namun perlu diperhatikan, jika kita membuat bean dengan tipe data yang sama, maka kitra harus menggunakan nama bean yang berbeda.
- selain itu, saat kita mengakses bean nya, kita wajib menyebutkan nama beannya, jika tidak spring akan bingung harus mengakses bean yang mana.
```

## Primary Bean

```
- untuk mengatasi duplicate bean, bisa membuat salah 1 menjadi primary
- be default jika getBean tanpa nama bean maka akan otomatis ambil bean yang primary

```

## Mengubah nama Bean

```
- default nama bean digunakan sebagai nama bean
- ada baiknya tidak menggunakan nama method, terutama jika aplikasi semakin besar
- bisa masukan value pasa anotation @Bean, dan nama harus unique
```

## DI or Dependency Injection

```
saat membuat object sering kali antar satu object mmembtutuhkan object yang lainnya.
- DI adalah teknik dimana kita bisa mengotomatisasikan proses pembuatan object yang tergantung dnegan object lain, atau kta sebut dependencies.
- dependencies akan secara otomatis di-inject (dimasukan) kedalam object yang membutuhkannya
- Spring Framework merupakan sebuah framework IoC yang memang cara kerjanya menggunakan Dependency Injection atau DI
```

## Memilih Dependency

```
- kadang saat menggunakan DI, kita ingin memilih object mana yang ingin kita gunakan
- saat terdapat duplicate Bean dengan tipe data yang sama, secara otomatis Spring akan memilih Bean yang primary, tapi bisa juga memlih secara manual dengan naming bean nya.
- bisa menggunakan annotation @Qualifier(value="nameBean) pada parameter di method nya
```

## Circular Depencies

```
- kasus dimana lingkaran dependencies terjadi
- misal bean A butuh B, bean B butuh C, bean C butuh A
- jika terjadi cyclic seperti ini, Spring dapat mendeteksi dan otomatis akan error
- hati2, berrti ada yg salah dengan design OOP yang dibuat

- error message
11:07:06.453 [main] WARN org.springframework.context.annotation.AnnotationConfigApplicationContext - Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'cyclicA' defined in devtobil.belajarspringdasar.CyclicConfiguration: Unsatisfied dependency expressed through method 'cyclicA' parameter 0; nested exception is org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'cyclicB' defined in devtobil.belajarspringdasar.CyclicConfiguration: Unsatisfied dependency expressed through method 'cyclicB' parameter 0; nested exception is org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'cyclicC' defined in devtobil.belajarspringdasar.CyclicConfiguration: Unsatisfied dependency expressed through method 'cyclicC' parameter 0; nested exception is org.springframework.beans.factory.BeanCurrentlyInCreationException: Error creating bean with name 'cyclicA': Requested bean is currently in creation: Is there an unresolvable circular reference?
```

## Depends On

```
- saat sebuah bean membutuhkan bean yg lain, maka secara otomatis bean tersebut akan dibuat setelah bean yang dibutuhkan dibuat.
- jika ingin sebuah bean dibuat setelah bean lain dibuat, bisa menggunakan anotasi @DependsOn(value="namaBean")

- contoh output log berdasarkan DepensOn.java
11:22:15.115 [main] INFO devtobil.belajarspringdasar.DependsOnConfiguration - Create New Bar
11:22:15.115 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'foo'
11:22:15.116 [main] INFO devtobil.belajarspringdasar.DependsOnConfiguration - Create New Foo

```

## Lazy Bean

```
- by default bean akan dibuat pertama kali, agar tidak perlu membuat object lagi.
- terkadang saat aplikasi spring dijalankan, aplikasi spring akan berjalan lambat.
- kita bisa juga membuat bean menjadi lazy atau malas, artinya saat aplikasi spring berjalan bean nya tidak akan dibuat sampai bean tersebut di akses.
- untuk membuat lazy tinggal tambahkan @Lazy
```

## Scope

```
- scope merupakan strategy cara sebuah object dibuat
- by default strategy object di spring adalah singleton, artinya hanya dibuat sekali dan ketika kita akses akan mengembalikan object yang sama
- namun kita bisa mengubah scope bean yang kita mau di spring
- untuk mengubah scope sebuah bean, kita bisa menambahkan annotation @Scope(value="namaScope")

- Bean Scope yg ada di spring
  - singleton   => default hanya dibuat sekali dalam spring IoC
  - prototype   => selalu dikeim object baru setiap kali bean di akses
  - request     => dibuat baru per HTTP request (hanya untuk web app)
  - session     => dibuat baru per HTPP session (hanya untuk web app)
  - application => dibuat baru per servletcontext (hanya untuk web app)
  - websocket   =>  dibuat baru per websocket(hanya untuk websocket app)

- output log dengan scope prototype
11:53:22.410 [main] INFO devtobil.belajarspringdasar.ScopeConfiguration - Create new Foo --- scope
11:53:22.411 [main] INFO devtobil.belajarspringdasar.ScopeConfiguration - Create new Foo --- scope
11:53:22.412 [main] INFO devtobil.belajarspringdasar.ScopeConfiguration - Create new Foo --- scope

```

## Membuat Scope

```
- buat class dengan implement interface Scope
- selanjutnya registratsikan dengan bean CustomScopeConfigurer
```

## Life Cycle

```
- spring memliki alur hidup dan kita bisa berinteraksi dengan alur tersebut.
- saat pertama kali spring berjalan, dan sudah membuat bean spring akan memberitahu bean tsb bahwa bean tsb sudah siap, artinya semua dependencies sudah dimasukan.
- ketika aplikasi spring akan mati, spring akan memberitahu semua bean bahwa bean tsb akan dihancurkan.

- Lifecycle callback
  - by default bean tidak tahu alur hidup spring
    - digunakan jika kita ingin bereaksi ketika Spring selesai membuat Bean
  - bisa menggunakan InitializingBean dan DispossableBean
    - digunakan jika kita ingin bereaksi ketika Spring akan menghancurkan Bean

- logger output lifecycle
13:26:45.915 [main] INFO devtobil.belajarspringdasar.data.Connection - Connection is ready to used ...
13:26:45.947 [main] DEBUG org.springframework.context.annotation.AnnotationConfigApplicationContext - Closing org.springframework.context.annotation.AnnotationConfigApplicationContext@703580bf, started on Tue Apr 19 13:26:45 WIB 2022
13:26:45.948 [main] INFO devtobil.belajarspringdasar.data.Connection - Connection is cloed ...

```

## Life Cycle Annotation

```
selain menggunakan interface InitializingBean dan DispossableBean, kita juga bisa menggunakan annotation untuk mendaftarkan callback ethod untuk lifecycle.
- initMethod() digunakan untuk meregistrasikan method mana yg akan dipanggil ketika bean selesai dibuat.
- destroyMethod() digunakan untuk meregistrasikan method mana yg akan dipanggil ketika bean akan dihancurkan.
- method harus tanpa parameter, return value tidak akan dihiraukan, pakai void ajah.

- logger output
17:49:49.295 [main] INFO devtobil.belajarspringdasar.data.Server - Start Server
17:49:49.331 [main] DEBUG org.springframework.context.annotation.AnnotationConfigApplicationContext - Closing org.springframework.context.annotation.AnnotationConfigApplicationContext@2e4b8173, started on Tue Apr 19 17:49:49 WIB 2022
17:49:49.332 [main] INFO devtobil.belajarspringdasar.data.Server - Stop Server

- annotations lainnya @PostConstruct dan @PreDestroy
- selain menggunakan @Bean kita bisa juga menggunakan dua anotasi di atas
- @PostConstruct merupakan method yang ditandai harus dipanggil ketika Bean selesai dibuat
- @PreDestroy merupakan method yang ditandai harus dipanggil ketika Bean akan dihancurkan
-  jika sudah menggunakan annotation ini gak perlu mention di @Bean
- logger output
17:56:32.122 [main] INFO devtobil.belajarspringdasar.data.Server - Start Server
17:56:32.158 [main] DEBUG org.springframework.context.annotation.AnnotationConfigApplicationContext - Closing org.springframework.context.annotation.AnnotationConfigApplicationContext@2e4b8173, started on Tue Apr 19 17:56:31 WIB 2022
17:56:32.159 [main] INFO devtobil.belajarspringdasar.data.Server - Stop Server

```

## Import

```
- biasanya membuat lebih dari 1 configuration class
- bisa menggunakan @Import annotation
- bisa import lebih dari 1 configuration
```

## Component Scan

```
- semakin besar aplikasi semakin banyak config yg harus di import
- component scan bisa digunakan untuk handle configuration dan akan scan basepackage
```

## Component

```
- membuat bean dengan menambahkan @Bean pada method
- secara otomatis kita bisa setup sebuah class dengan @Component untuk membuat bean untuk class tersebut
- @Component mendukung pembuatan 1 buah bean
- saat menggunakan @Component, nama bean akan dibuatkan secara otomatis
- jika menggunakan @ComponentScan, nama bean akan menjadi camelCase, contoh ProductWeb jadi productWeb
- jika menggunakan @Import, secara otmatis nama bean akan menjadi ClassName.class.getName()
- namun jika ingin membuat nama berbeda, bisa juga menggunakan @Component(value="namaBean)
- annotation lain masih bisa digunakan di @Component
```

## Constructor Base Dependency Injection

```
- untuk melakukan dependency injection di @Bean, kita bisa menggunakan parameter di methodnya
- secara otomatis spring akan memilih bean mana yg cocok
- bagaimana jika menggunakan @Component ?
  - menggunakan constructor parameter, hanya mendukung 1 constructor

- bagaimana jika harus multiple contructor
  - menggunakan annotation @Autowired
```

## Setter-based Dependency Injection

```
- khusus case ini harus menggunakan annotation @Autowired pada setter method nya
- setter-based DI bisa digabung dengan constructor-based DI
```

## Field-based Dependency Injection

```
- menambahkan @Autowired pada field
- @Autowired dapat digabungkan dengan setter-based DI dan constructor-based DI
- tidak direkomendasikan menggunakan
```

## Qualifier

```
- spring akan bingung jika ada bean dengan object yg sama
- didalam component pun kita bisa set qualifier

- notes:
  - jika lombok annotations tidak berfungsi pada vscode, coba install extension lombok
```

## Optional Dependency

```
- by default semua dependency itu wajib
- jika spring tidak menemukan bean yg dibutuhkan maka akan terjadi error
- namun jika kita ingin membuat sebuah dependency itu optional, bisa kita warpping dengan java.util.Optional<T>
- Optional<T> dapat kita gunakan pada @Bean, atayupun @Component

- selain menggunakan Optional<T>, kita bisa juga menggunakan ObjectProvider<T>
- yang membedakan adalah, jika ternyata bean nya lebih dari satu, ObjectProvider<T> dapat digunakan untuk mengambil semuanya.
- disarankan menggunakan Optional<T>
```

## Factory Bean

```
- kadang kala ada kasus  class bukan milik kita melainkan third party
- jadinya agak sulit buat nambahin anotation di class tsb
- caranya bisa kita tambahkan @Bean atau @Component tapi perlu wrap pada class Factory Bean
```

## Inheritance

```
- saat mengakses bean kita bisa mengakses tipe class bean tsb atau bisa juga dengan parent/interface class bean
- hati2 duplicate bean saat implmentasi interface

```

## Bean Factory

```
- ApplicationContext adalah interface turunan dari BeanFactory
- BeanFactory merupakan kontrak untuk management bean di spring

- Listable Bean Factory
  - BeanFactory hanya bisa digunakan untuk mengakses single bean
  - jika ingin mengakses beberapa bean bisa menggunakan Listable Bean Factory
  - Application Context juga merupakan turunan dari Listable Bean Factory

-- output log
BeanFactoryTest.java
[devtobil.belajarspringdasar.data.Foo@79dc5318, devtobil.belajarspringdasar.data.Foo@8e50104, devtobil.
belajarspringdasar.data.Foo@37e4d7bb]
{foo1=devtobil.belajarspringdasar.data.Foo@79dc5318, foo2=devtobil.belajarspringdasar.data.Foo@8e50104, foo3=devtobil.belajarspringdasar.data.Foo@37e4d7bb}

```

## Bean Post Processor

```
- Bean Post Processor kurang lebih seperti midleware yang diakses sebelum bean di initialized dan setelah bean di initialized
- karena sangat flexible, bahkan Bean Post Processor bisa memodifikasi hasil object Bean

-- Bean ID Generator
  - misal kita akan coba membuat id unique untuk bean
  - membuat interface dengan nama IdAware, lalu memiliki method setId(string)
  - kita akan membuat Bean Post Processor, dimana jika bean nya implements IdAware, kita akan setId(string) nya menggunakan UUID
```

## Ordered

```
- Saat kita membuat Bean Post Processor, kita bisa membuat lebih dari satu
- Kadang ada kasus saat mmembuat beberapa Bean Post Processor, kita ingin membuat yang berurutan
- sayangnya sacaradefault, Spring tidak menjamin urutan eksekusi
- agar kita bisa menentukan urutannya, kita bisa menggunakan interface ordered
```

## Aware

```
- spring memiliki sebuah interface bernama aware
- aware merupakan sebuah super interface yang digunakan oleh semua Aware interface
- aware digunakan sebagai penanda agar spring melakukan injection object yang kita butuhkan
- mirip dengan yang sudah dilakukan dengan Bean Post Processor
- namun kali ini tidak perlu membuat bean post processor secra manual
```

## Bean Factory Post Processor

```
- by default mungkin hampir tidak pernah sama sekali membuat Application Context secara manual
- namun kadang kala perlu membuat untuk kebutuhan internal
- spring merekomendasikan bean factory post processor
```

## Event Listener

```
- spring memiliki feature event-listener yang bisa kita gunakan untuk berkomunikasi antar class
- Event di spring merupakan Object turunan dari ApplicationEvent, sedangkan Listener di spring merupakan object turunan dari ApplicationListener
- untuk mengirim event ke listener, kita bisa menggunakan object ApplicationEventPublisher yang merupakan super interface dari ApplicationContext
- bisa juga menggunakan ApplicationEventPublisherAware untuk mendapatkan ApplicationEventPublisher
- kenapa butuh event listener padahal bisa ajah kita masukan langsung ?
  - karena kitta bisa setup berbagai jenis lietener dari class yang berbeda yang membutuhkan sehingga akan lebih mudah.
-- contoh output log
06:27:05.205 [main] INFO devtobil.belajarspringdasar.service.UserService - set ApplicationEventPublisher
06:27:05.233 [main] INFO devtobil.belajarspringdasar.listener.LoginSUccessListener - Success login for user User(username=tobils)

```

## Event Listener Annotation

```
- selain menggunakan interface ApplicationListener, kita bisa menggunakan annotation untuk membuat listener dan ini lebih flexible
- dan agar 1 bean bisa mendengarkan berbagai event tidak hanya 1 event
- kita bisa menggunakan @EventListener
- cara kerja ?
  - menggunakan bean post processor
  - spring akan registrasi bean baru dan akan detect method dengan anotasi @EventListener
  - jika terdapat bean baru dengan @EventListener maka akan dibuat bean baru
```

## Spring boot Application

```
- sebelum nya selalu menggunakan aplicationcontext secara manual agar paham alurnya bagaimana springboot application bisa berjalan secara otomatis
- ganti @Configuration utama dnegan @SpringBootApplication
- @SpringBootApplication sendiri berisi gabungan @configuration dan banyak hal lain seperti @ComponentScan

- @SpringApplication dapat digunakan untuk menggantikan ApplicationContext
- @SpringBootTest digunakan untuk unit test secara otomatis dan tidak perlu ambil bean secara manual
  - data menggunakan DI secara langsung menggunakan @Autowired
```

## Startup Failure

```
- spring memiliki feature failure analyzer
- FailureAnalyzer digunakan untuk melakukan analisa ketika terjadi error startup yang menyebabkan aplikasi tidak mau berjalan
- spring sudah menydeiakan classs implementasi yg dapat kita gunakan

-- output
Error starting ApplicationContext. To display the conditions report re-run your application with 'debug' enabled.
2022-04-23 12:48:49.487 ERROR 35052 --- [           main] o.s.b.d.LoggingFailureAnalysisReporter   :

***************************
APPLICATION FAILED TO START
***************************

Description:

Parameter 0 of method foo in devtobil.belajarspringdasar.application.FooApplication required a bean of type 'devtobil.belajarspringdasar.data.Bar' that could not be found.
2

Action:

Consider defining a bean of type 'devtobil.belajarspringdasar.data.Bar' in your configuration.

```

## Banner

```
- springboot memiliki fitur banner, dimana saat apliaksi dijalankan kita bisa menuliskan banner di console
- secara default fitur banner ini akan menyala dan akan mencari tulisan banner di class patch dengan nama banner.txt

- salah satu web untuk embuat banner : https://bagill.com/ascii-sig.php
- jika tidak ketemu maka spring secara otomatis akan menampilkan tulisan springboot pada aplikasi
-- default banner
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.6.6)

-- custom banner: copy paste character dibawah ini pada folder properties, kemudian buat file banner.txt
  __| | _____   __    | |_ ___ | |__ (_) |
 / _` |/ _ \ \ / /____| __/ _ \| '_ \| | |
| (_| |  __/\ V /_____| || (_) | |_) | | |
 \__,_|\___| \_/       \__\___/|_.__/|_|_|
 :: Spring Boot ::                (v2.6.6)
```

## Customizing Spring Application

```
- kadang kala kita perlu melakukan pengaturan pada spring application sebelum application contex-nya dibuat
- kita bisa menggunakan SpringApplication atau SpringApplicationBuilder
- check FooApplication
```

## Spring Application Event

```
- sama hal nya event listener yang sudah dipelajari
- di springBoot ketika aplikasi berjalan banyak sekali event yang dikirim
- kita bisa membuat listener untuk mendapatkan event tsb

-- menambah listener
  - beberapa event di spring boot application event di trigger bahkan sebelum spring membuat application context
  - oleh karena itu jika kita menggunakan bean, bisa saja beberpa listener tidak akan dipanggil karena bean nya belum dibuat
  - agar lebih aman kita bisa menambahkan listener ketika membuat SpringApplication

  -- output log example
  13:21:36.699 [main] INFO devtobil.belajarspringdasar.listener.AppStartingListener - [listener] Application is starting
```

## Command Line Runner

```
- kadang kala kita perlu menambahkan argument pada main method
- SpringApplication dapat secara otomatis mengirikan argument tersebut ke Bean yang kita buat
- kita hanya butuh membuat bean dari ComandLineRunner
- COmmandLineRunner secara otomatis akan dijalankan saat SpringApplication berjalan
```

## Application Runner

```
- Selain CommandLineRunner Springboot menyediakan fiture ApplicationRunner
- penggunannya sama saja namun, argument nya sudah di wrapping dalam object ApplicationRunner
- menariknya, APplicationRunner memiliki fitur parsing command line argument
```

## Spring Boot Plugin

```
- plugin ini bisa digunakan untuk mempermudah kita saat menjalankan aplikasi springboot
- contoh : mvn spring-boot:run
- install maven: sudo apt install maven
- untuk menjalan spring boot aplikasi kita harus memastikan hanya ada 1 main class
-- Distribution File
  - plugin ini mendeteksi main class pada project, lalu membundle aplikasi kita beserta dependecy yang dibutuhkan dalam 1 file jar
  - pastikan hanya ada 1 main class
  - command: mvn package
  - secara otomatis akan terbuat single jar application.
  - untuk runnning tinggal : java --jar path-jar-file
```
