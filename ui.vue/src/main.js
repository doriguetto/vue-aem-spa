import Vue from 'vue'
import VueRouter from 'vue-router'

import App from './components/App'
import AppFormRadio from './components/forms/Radio'
import AppFormTextfield from './components/forms/TextField'
import AppQuestion from './components/collection/Question'

Vue.config.productionTip = false

if (process.env.NODE_ENV === 'production') {
  Vue.config.silent = true;
  Vue.config.debug = false;
  Vue.config.devtools = false;
}

Vue.use(VueRouter)

Vue.component('app-form-radio', AppFormRadio)
Vue.component('app-form-textfield', AppFormTextfield)
Vue.component('app-question', AppQuestion)

new Vue(App)
