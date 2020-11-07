import Vue from 'vue'
import VueRouter from 'vue-router'

import App from './components/App'

Vue.config.productionTip = false

if (process.env.NODE_ENV === 'production') {
    Vue.config.silent = true;
    Vue.config.debug = false;
    Vue.config.devtools = false;
}

Vue.use(VueRouter)

new Vue(App)
