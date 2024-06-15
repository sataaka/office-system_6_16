# ステージ1: ビルド環境
# Mavenイメージを使ってJavaアプリケーションをビルド
FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app
# プロジェクトファイルをコンテナ内にコピー
COPY pom.xml .
COPY src ./src
# アプリケーションをビルド
RUN mvn clean package -DskipTests

# ステージ2: 実行環境
# 軽量なJava Runtime Environmentを使用
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
# ビルドステージからビルド済みのWARファイルをコピー
COPY --from=build /app/target/office-system_3_25-0.0.1-SNAPSHOT.war /app/app.war
# アプリケーションのポートを開放
EXPOSE 8080
# アプリケーションを実行
ENTRYPOINT ["java", "-jar", "app.war"]
