# derby_study

## 概要
[Apache Derby](https://db.apache.org/derby/)でDBを作成して[Flyway](https://flywaydb.org/)で初期化を行う

## 必須事項
- JRE ver 1.8以上
- [Apache Maven](https://maven.apache.org/)3.5.3以上

## 使い方

```sh
# gitリポジトリをクローンしてフォルダ内に移動
git clone https://github.com/MasaoBlue/derby_study.git
cd derby_study

# FlywayでDBマイグレーションの初期設定、およびマイグレーションを実行
mvn flyway:baseline flyway:migrate

# DBに接続できることを確認
mvn test
```
