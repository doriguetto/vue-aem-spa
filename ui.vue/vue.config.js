const merge = require('merge')
const baseConfig = require('./config/vue.base.config')
const prodConfig = require('./config/vue.prod.config')
const testConfig  = require('./config/vue.test.config')
const devConfig  = require('./config/vue.dev.config')

module.exports = () => {
  if (process.env.NODE_ENV === 'production')
    return merge(baseConfig, prodConfig)
  else if (process.env.NODE_ENV === 'production') {
    return merge(baseConfig, testConfig)
  } else {
    return merge(baseConfig, devConfig)
  }
}
