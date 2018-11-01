# Latihan Android

> Berikut contoh aplikasi android yang memanfaatkan Library [Retrofit](https://square.github.io/retrofit "Retrofit") untuk mengolah (consume) API. 

##Instalasi

1. Download / Clone Project
    ```
    https://github.com/cerc-undip/SimpleApp-Android.git
    ```

2. Import file `vizyan.sql` ke **PhpMyadmin** di hosting masing - masing

3. Pindahkan semua file yang ada pada folder **php** ke hosting masing - masing

4. Ganti konfigurasi yang ada pada file `connection.php`
    ```
    localhost -> alamat hosting
    username -> username database
    password -> password database
    database -> nama database
    ```

5. Buka Project menggunakan **Android Studio**

6. Ganti   `BASE_URL` yang ada pada class `Constant.java` dalam package **utils** menjadi alamat webhost masing - masing

7. Run menggunakan emulator atau smartphone android, jangan lupa hubungkan dengan internet