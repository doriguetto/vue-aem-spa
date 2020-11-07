<template>
  <div :data-cq-data-path="cqPath">
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
      <router-link class="navbar-brand" to="/content/vue-aem-spa/home.html">Home</router-link>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor02" aria-controls="navbarColor02" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarColor02">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item" v-for="(item, index) in childrenModel" :key="index">
            <router-link class="nav-link" :class="{ active : isCurrent(item[CONSTANTS.PATH])}" :to="item[CONSTANTS.PATH] + '.html'" :key="index">
              {{item.title}} <span class="sr-only" v-if="isCurrent(item[CONSTANTS.PATH])">(current)</span></router-link>
          </li>
        </ul>
        <form class="form-inline">
          <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
          <button class="btn btn-outline-light my-2 my-sm-0" type="submit">Search</button>
        </form>
      </div>
    </nav>
  </div>
</template>

<script>
  import { VueSPAComponentManager, VueSPAComponentMixin } from 'vue-spa-component-mapping'

  export default VueSPAComponentManager.mapTo({
    name: 'AppNavbar',
    resourceType: 'vue-aem-spa/components/content/nav',
    mixins: [ VueSPAComponentMixin ],
    methods: {
      isCurrent(page) {
        return page === this.$route.path.replace('.html','')
      },
    },
    computed: {
      rootPath() {
        return this.$route.path
      }
    }
  })

</script>

<style lang="scss">

  @import "~bootstrap/scss/nav";
  @import "~bootstrap/scss/navbar";
  @import "~bootstrap/scss/forms";
  @import "~bootstrap/scss/buttons";
</style>
