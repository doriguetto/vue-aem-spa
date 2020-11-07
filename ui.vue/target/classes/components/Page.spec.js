import { shallowMount } from '@vue/test-utils'
import Page from './Page'
import Vue from 'vue'
import Store from "../store";
import { ADD_HANDLER } from "../store/constants";
import pageHandlers from "../handlers/page";
import modalHandlers from "../handlers/modal";

Vue.config.debug = true;
Vue.config.async = false;

describe('Page', () => {

  let component
  const props = {
    handler: 'myGenericPage'
  }

  beforeEach(() => {
    component = shallowMount(Page, {
      store: Store,
      propsData: props,
    })
  })

  it('is a Vue instance', () => {
    expect(component.isVueInstance()).toBeTruthy()
  })

  it("has the expected html structure", () => {
    expect(component.element).toMatchSnapshot();
  })

  it("should have a handler", () => {
    expect(component.vm.handler).toBe('myGenericPage');
  })

  it("should not have a handler", () => {
    const emptyComponent = shallowMount(Page, {
      propsData: {},
    })
    expect(emptyComponent.vm.handler).toBeUndefined();
  })

  it("should not have a handler", () => {

    jest.spyOn(pageHandlers.myGenericPage, 'init')

    Store.commit(ADD_HANDLER, {
      name: 'myGenericPage',
      type: 'page',
      ['myGenericPage'] : pageHandlers.myGenericPage
    })


    const emptyComponent = shallowMount(Page, {
      store: Store,

      propsData: {

        handler: 'hanlderThatDontExists'
      },
    })
    expect(pageHandlers.myGenericPage.init).not.toHaveBeenCalled()

  })

  it("should init page handler, if exit", () => {

    jest.spyOn(pageHandlers.myGenericPage, 'init')

    Store.commit(ADD_HANDLER, {
      name: 'myGenericPage',
      type: 'page',
      ['myGenericPage'] : pageHandlers.myGenericPage
    })

    const emptyComponent = shallowMount(Page, {
      store: Store,
      propsData: {
        handler: 'myGenericPage'
      },
    })
    expect(pageHandlers.myGenericPage.init).toHaveBeenCalled()

  })


})
