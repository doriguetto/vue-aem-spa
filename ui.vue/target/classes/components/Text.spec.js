import { shallowMount } from '@vue/test-utils'
import Text from './Text'
import Vue from 'vue'

Vue.config.debug = true;
Vue.config.async = false;


describe('Text', () => {

  let component
  const props = {

  }

  beforeEach(() => {
    component = shallowMount(Text, {
      propsData: props,
    })
  })

  it('is a Vue instance', () => {
    expect(component.isVueInstance()).toBeTruthy()
  })
  it("has the expected html structure", () => {
    expect(component.element).toMatchSnapshot();
  })


})
