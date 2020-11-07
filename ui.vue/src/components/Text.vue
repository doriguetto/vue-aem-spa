<template>
  <div :data-cq-data-path="cqPath">
    <div v-html="text"></div>
    <div v-if="isEmpty" data-emptytext="Text" class="cq-placeholder"></div>
  </div>
</template>

<script>

  import { VueSPAComponentMixin , VueSPAComponentManager } from 'vue-spa-component-mapping'

  export default VueSPAComponentManager.mapTo({
    name: 'AppText',
    resourceType: 'vue-aem-spa/components/content/text',
    mixins: [ VueSPAComponentMixin ],
    computed: {
      text: function () {
        return this.model.text
      },
      isEmpty: function () {
        return !this.text
      },
    }
  })
</script>
