<template>
  <div :data-cq-data-path="cqPath" :class="styleClasses">
    <img :src="src" :alt="alt">
    <div v-if="isEmpty" data-emptytext="Image" class="cq-placeholder"></div>
  </div>
</template>

<script>

  import { VueSPAComponentMixin , VueSPAComponentManager } from 'vue-spa-component-mapping'

  export default VueSPAComponentManager.mapTo({
    name: 'AppImage',
    resourceType: 'vue-aem-spa/components/content/image',
    mixins: [ VueSPAComponentMixin ],
    computed: {
      alt: function() {
        return this.model.alt
      },
      src: function () {
        return this.model.src
      },
      styleClasses: function() {
        return this.model.styleClasses? this.model.styleClasses.map((item) => ({[item] : true })) : undefined
      },
      isEmpty: function () {
        return !this.src
      },
    }
  })
</script>
