const path = require("path");

module.exports = {
  entry: path.resolve("src/index.js"),
  output: {
    path: path.resolve("public"),
    filename: "bundle.js",
  },
  module: {
    rules: [
      {
        test: /\.js$/,
        exclude: /node_modules/,
        loader: "babel-loader",
      },
      {
        test: /\.css$/,
        loader: ["style-loader", "css-loader"],
      },
    ],
  },
  devServer: {
    contentBase: path.resolve("public"),
    host: "0.0.0.0",
    port: 8090,
    inline: true,
    liveReload: true,
    hot: false, // hot을 하던지 liveReload 하던지
    compress: true,
    historyApiFallback: true,
  },
};
