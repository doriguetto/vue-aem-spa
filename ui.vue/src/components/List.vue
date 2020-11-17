<template>
  <div :data-cq-data-path="cqPath" :class="styleClasses" :id="componentId">
    <component :is="listComponent" :items="items"></component>
    <div v-if="isEmpty" data-emptytext="List" class="cq-placeholder"></div>
  </div>
</template>

<script>

  import { VueSPAComponentMixin , VueSPAComponentManager } from 'vue-spa-component-mapping'
  import AppNavList from './lists/NavList'
  import AppGenericList from './lists/GenericList'

  export default VueSPAComponentManager.mapTo({
    name: 'AppList',
    resourceType: 'vue-aem-spa/components/content/list',
    components: {
      AppNavList,
      AppGenericList
    },
    mixins: [ VueSPAComponentMixin ],
    computed: {
      listComponent () {
        if (this.model.linkItems) {
          return 'app-nav-list'
        } else {
          return 'app-generic-list'
        }
      },
      styleClasses: function() {
        return this.model.styleClasses? this.model.styleClasses.map((item) => ({[item] : true })) : undefined
      },
      componentId () {
        return this.model.id
      },
      items() {
        return this.model.items
      },
      isEmpty: function () {
        return !this.src
      },
    }
  })
</script>

<style lang="scss">
  @import "~bootstrap/scss/list-group";
</style>
