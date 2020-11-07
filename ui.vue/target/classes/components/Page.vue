<template>
  <div>
    <component :is="renderTo(item)" :key="index" v-for="(item, index) in model[':items']" :child-model="item" :cq-path="childPath + index"></component>
  </div>
</template>

<script>
  import { VueSPAComponentMixin , VueSPAComponentManager } from 'vue-spa-component-mapping'

  import Components from '.'
  import AppResponsiveGrid from './ResponsiveGrid'

  export default VueSPAComponentManager.mapTo({
    name: 'AppPage',
    components: {
      ...Components,
      AppResponsiveGrid
    },
    resourceType: 'vue-aem-spa/components/structure/page',
    mixins: [ VueSPAComponentMixin ],
  })
</script>
