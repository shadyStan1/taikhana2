 FROM microsoft/dotnet:2.1-sdk AS build-env
 RUN curl -sL https://deb.nodesource.com/setup_8.x | bash - && apt-get install -yq nodejs
 WORKDIR /app
 COPY . ./
 RUN dotnet publish -c Release -o out

 FROM microsoft/dotnet:2.1-aspnetcore-runtime AS runtime
 WORKDIR /app
 COPY --from=build-env /app/out .
 ENTRYPOINT ["dotnet", "dotnetdemoapp.dll"]