# derby_study

## 概要
[Apache Derby](https://db.apache.org/derby/)でDBを作成して[Flyway](https://flywaydb.org/)で初期化を行う

## 必須事項
- JRE ver 1.8以上
- [Apache Maven](https://maven.apache.org/)3.5.3以上

※Linux系の場合、以下の「mvnw.cmd」を「./mvnw」に置き換えて実行してください。

## 起動手順

### ソースを取得
```sh
# gitリポジトリをクローンしてフォルダ内に移動
git clone https://github.com/MasaoBlue/derby_study.git
cd derby_study
```

以下、`derby_study`ディレクトリ配下で実行

### DB初期化
```sh
# FlywayでDBマイグレーションの初期設定、およびマイグレーションを実行
mvnw.cmd initialize flyway:baseline flyway:migrate

# DBに接続できることを確認
mvnw.cmd test
```
