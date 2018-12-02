import * as React from 'react'
import {observer, inject} from 'mobx-react'

import {TodoStore} from '../../store/todo.store'
import {TodoListItem} from './todo.list.item'

interface TodoListProps {
    todoStore?: TodoStore
}

export const TodoList = inject('todoStore')(
    observer(({todoStore: {todoList}}: TodoListProps) => 
        TodoList.map((todo, idx) => <TodoListItem key={idx} todo={todo} />),
    ),
)