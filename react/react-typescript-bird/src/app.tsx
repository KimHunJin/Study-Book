import * as React from 'react'
import { Provider } from 'mobx-react'
import { Component } from 'react'

import { TodoStore } from './store/todo.store'

import {TodoAdd} from './components/add/todo.add'
import {TodoList} from './components/list/todo.list'

export class App extends Component {

    private todoStore: TodoStore = new TodoStore()

    render(){
        return (
            <Provider todoStore={this.todoStore}>
                <div>
                    <TodoAdd />
                    <TodoList />
                </div>
            </Provider>
        )
    }

}