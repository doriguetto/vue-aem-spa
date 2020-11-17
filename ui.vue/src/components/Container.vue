<template>
  <div :data-cq-data-path="cqPath" :class="gridClassName" :style="backgroundStyle" :id="containerId">
    <component :class="componentClass(index)" :is="renderTo(item)" :key="index" v-for="(item, index) in model[CONSTANTS.ITEMS]" :child-model="item" :cq-path="childPath + index"></component>
    <div v-if="allowedComponents && allowedComponents.applicable" class="aem-AllowedComponent--list new section aem-Grid-newComponent">
      <div data-text="Layout Container" class="aem-AllowedComponent--title"></div>
      <div v-for="(component, index) in allowedComponents.components" :key="index" :data-cq-data-path="component.path" :data-emptytext="component.title" class="aem-AllowedComponent--component cq-placeholder placeholder"></div>
    </div>
    <div :data-cq-data-path="parSysPath" class="new section aem-Grid-newComponent"></div>
  </div>
</template>

<script>
  import { VueSPAComponentMixin , VueSPAComponentManager } from 'vue-spa-component-mapping'

  import Components from '.'

  export default VueSPAComponentManager.mapTo({
    name: 'AppContainer',
    resourceType: 'vue-aem-spa/components/content/container',
    mixins: [ VueSPAComponentMixin ],
    components: {
      ...Components,
    },
    methods: {
      componentClass(index) {
        return (this.model.columnClassNames[index]?this.model.columnClassNames[index]: false)
      },
    },
    computed: {
      gridClassName() {
        return (this.model.gridClassNames? this.model.gridClassNames : false)
      },
      backgroundStyle() {
        return this.model.backgroundStyle
      },
      containerId() {
        return this.model.id
      }
    }
  })

</script>
