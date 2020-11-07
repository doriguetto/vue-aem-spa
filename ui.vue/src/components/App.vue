<template>
  <div>
    <router-view :key="$route.fullPath" ></router-view>
  </div>
</template>

<script>
  import VueRouter from 'vue-router'
  import { VueSPAAppMixin, CONSTANTS } from 'vue-spa-component-mapping'

  import AppPage from './Page'
  let homePage = '/content/vue-aem-spa/home.html'

  export default {
    el: '#app',
    router: new VueRouter({
      mode: 'history'
    }),
    components: {
      AppPage
    },
    methods: {
      onModelChange(model) {
        // init home page route
        let routes = [{
          path: model[CONSTANTS.PATH] + '.html',
          component: AppPage,
          props: {
            cqPath: this.cqPath,
            childModel: model,
          }
        }]

        for(let page in model[CONSTANTS.CHILDREN]) {
          routes.push({
            path: page + '.html',
            component: AppPage,
            props: {
              cqPath: page + '/' + CONSTANTS.JCR_CONTENT,
              childModel: model[CONSTANTS.CHILDREN][page],
            }
          })
        }
        this.$router.addRoutes(routes)
        if (this.$router.currentRoute.path === '/') this.$router.push(homePage)
      }
    },
    cmsPath: (process.env.NODE_ENV === 'development'? homePage: ''),
    mixins: [ VueSPAAppMixin ],
  };

</script>

<style lang="scss">
  // Bootstrap - Optional features
  @import "~bootstrap/scss/reboot";
  @import "~bootstrap/scss/utilities/spacing";

</style>
