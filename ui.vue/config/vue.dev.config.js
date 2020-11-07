module.exports = {
  devServer: {
    proxy: 'http://localhost:4502'
  },
  configureWebpack: {
    devtool: 'source-map'
  },
}
