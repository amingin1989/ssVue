import Vue from './vue'
import Router from './vue-router'
import Index from '@/components/Index'
import Page from '@/components/page'

Vue.use(Router)

export default new Router({
    routes: [
        {
            path: "/",
            redirect: {
                name: "Index"
            }
        },
        {
            path: '/index',
            name: 'Index',
            component: Index
        },
        {
            path: '/page',
            name: 'Page',
            component: Page
        }
    ]
})