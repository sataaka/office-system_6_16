# ビルドステージ: Mavenを使用してアプリケーションをビルド
FROM maven:3-eclipse-temurin-17 AS build

# 作業ディレクトリを設定
WORKDIR /app

# プロジェクトのソースコードをコンテナにコピー
COPY . .

# Mavenを使用してプロジェクトをクリーンし、パッケージング（テストはスキップ）
RUN mvn clean package -DskipTests

# 実行ステージ: 軽量なJREイメージを使用してアプリケーションを実行
FROM eclipse-temurin:17-jre-alpine

# 作業ディレクトリを設定
WORKDIR /app

# ビルドステージから生成されたWARファイルをコピー
COPY --from=build /app/target/office-system_3_25-0.0.1-SNAPSHOT.war app.war

# コンテナがリッスンするポートを公開
EXPOSE 8080

# アプリケーションをTomcatサーバーで実行
ENTRYPOINT ["java", "-jar", "app.war"]
