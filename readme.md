# belajar spring framework

## IoC [Inversion Of Control]

```
prinsip dalam pembuatan perangkat lunak, dimana kita mmelakukan pemindahan control untuk object atau program
ke sebuah container dalam framework.
memliki control:
- eksekusi program
- management object
- melakukan abstraction
- code program harus mengikuti carakerja framework

spring merupakan sebuah framework IoC.
goods news nya karena harus mengikuti cara bekerja framework, setiap engineer bisa satu irama dalam membuat code program.
container IoC spring adalam aplication context
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
