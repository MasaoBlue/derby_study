# derby_study

## 概要
[Apache Derby](https://db.apache.org/derby/)でDBを作成して[Flyway](https://flywaydb.org/)で初期化を行う

## 必須事項
- JRE ver 1.8以上
- [Apache Maven](https://maven.apache.org/)3.5.3以上

## 起動手順

### ソースを取得
```sh
# gitリポジトリをクローンしてフォルダ内に移動
git clone https://github.com/MasaoBlue/derby_study.git
cd derby_study
```

以下、`derby_study`ディレクトリ配下で実行

### DBサーバ起動
```sh
mvn org.carlspring.maven:derby-maven-plugin:run

# jdbc接続文字列は「jdbc:derby://localhost/sample」
```

### DB初期化
```sh
# FlywayでDBマイグレーションの初期設定、およびマイグレーションを実行
mvn flyway:baseline flyway:migrate

# DBに接続できることを確認
mvn test
```


## 停止手順
### DBサーバ停止
```sh
mvn org.carlspring.maven:derby-maven-plugin:stop
```
