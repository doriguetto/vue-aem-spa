module.exports = {
  outputDir: './target/dist',
  productionSourceMap: false,
  filenameHashing: false,
  css: {
    loaderOptions: {
      // pass options to sass-loader
      sass: {
        // @/ is an alias to src/
        // so this assumes you have a file named `src/variables.scss`
        additionalData: `@import "~@/scss/_custom.scss";`
      },
    }
  },
  configureWebpack: {
    devtool: false,
    entry: {
      app: './src/main.js',
    },
  },
}
