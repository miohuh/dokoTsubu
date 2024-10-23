# dokoTsubu

## 概要
PostgreSQLデータベースと連携させたチャット管理Webアプリケーションです。
自身のつぶやきや相手のつぶやきを見ることができます。

## 機能
- ユーザー登録・ログイン・ログアウト機能
- チャットの閲覧・投稿

## データベース作成に使用したSQL文
 詳細なSQL文は、以下のファイルをご覧ください :
 - [dokotsubu.sql](dokotsubu.sql)

## スクリーンショット

|   機能名      | スクリーンショット                             | 説明                   |
|-------------|----------------------------------------------|------------------------|
|  ログイン画面  | ![rogin](https://github.com/user-attachments/assets/ebbf0e7e-543e-444d-b2c5-d5dcd2f9b309) | 登録したユーザー情報でログインできます <br> <関連コード> <br>[Login.java(サーブレット)](dokoTsubu/src/main/java/servlet/Login.java) / [LoginLogic.java](dokoTsubu/src/main/java/model/LoginLogic.java) / [UsersDAO.java](dokoTsubu/src/main/java/model/UsersDAO.java) / [User.java](dokoTsubu/src/main/java/model/User.java) / [index.jsp](dokoTsubu/src/main/webapp/index.jsp)|
|  ユーザー登録画面  | ![登録](https://github.com/user-attachments/assets/e6f9ad04-41ee-4c7f-b7c8-1ad6b3c9aa54) | IDとPASSWARDでユーザー登録を行います  <br> <関連コード> <br>[Submit.java(サーブレット)](dokoTsubu/src/main/java/servlet/Submit.java) / [LoginLogic.java](dokoTsubu/src/main/java/model/LoginLogic.java) / [UsersDAO.java](dokoTsubu/src/main/java/model/UsersDAO.java) / [User.java](dokoTsubu/src/main/java/model/User.java) / [submit.jsp](dokoTsubu/src/main/webapp/WEB-INF/jsp/submit.jsp)|
|  ログイン完了画面  | ![ログイン完了](https://github.com/user-attachments/assets/c3f84f6a-7a00-4ef1-ab1c-2c422e7698be)  | ユーザー情報がDBに登録されていたら完了します<br> <関連コード> <br>[loginResult.jsp](dokoTsubu/src/main/webapp/WEB-INF/jsp/loginResult.jsp)|
| 　メイン画面  | ![つぶやき画面](https://github.com/user-attachments/assets/b75ed866-d7db-4073-9cdd-ab7130a59d23)　| ログインしているユーザーのつぶやきが表示され、自身のつぶやきができます<br> <関連コード> <br> [Main.java(サーブレット)](dokoTsubu/src/main/java/servlet/Main.java) / [PostMutterLogic.java](dokoTsubu/src/main/java/model/PostMutterLogic.java) / [MuttersDAO.java](dokoTsubu/src/main/java/model/MuttersDAO.java) / [GetMutterListLogic.java](dokoTsubu/src/main/java/model/GetMutterListLogic.java) / [Mutter.java](dokoTsubu/src/main/java/model/Mutter.java) / [main.jsp](dokoTsubu/src/main/webapp/WEB-INF/jsp/main.jsp)|
|  ログアウト画面  | ![ログアウト](https://github.com/user-attachments/assets/c5c21f56-309f-4675-86ee-82ccba28d505) | メイン画面からログアウトリンクへ進むとログアウトされます <br> <関連コード> <br> [Logout.java](dokoTsubu/src/main/java/servlet/Logout.java) / [logout.jsp](dokoTsubu/src/main/webapp/WEB-INF/jsp/logout.jsp)|


## 開発の動機
 「スッキリわかるサーブレット＆JSP入門」第十章を元に、授業の学習の一環でこのアプリケーションを作成しました。
 教科書記載のものに追加機能として、ユーザー情報をデータベースで管理する機能をつけました。

## 学びと反省
初めてのデータベースと連携させたアプリケーション開発を行いました。コントローラ・モデル・ビューと役割をわけることで学んだことを理解しながら開発が行えました。
エラーの原因の追究が不慣れで難しかったです。様々なコードや開発に携わり、勉強したいと思っています。

## 今後の改善点
 デザイン面に全く触れてないので作りこんでいきたいです。画面遷移が多いので、画面を減らし使いやすくしたいと思います。

