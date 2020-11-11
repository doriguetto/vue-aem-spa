<template>
  <div>
    <component
      :is="getQuestionType(data)"
      :data="data">
    </component>
  </div>
</template>

<script>
  export default {
    props: {
      data: {
        type: Object,
        default: () => {}
      },
      id: String
    },
    methods: {
      getQuestionType(data) {
        if (data.type)
          switch (data.type) {
            case 'radio':
              return 'app-form-radio'
            default:
              return 'app-form-textfield'
        }
      }
    }
  }
</script>
