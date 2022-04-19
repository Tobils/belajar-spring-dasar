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

## Lifecycle

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
