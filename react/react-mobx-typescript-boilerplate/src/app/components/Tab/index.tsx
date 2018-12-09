import * as React from 'react'
import {Link} from 'react-router-dom'
import * as style from './style.css'

export const TabMenu = (title) => {
    return (
        <div>
            <ul className={style.gnb}>
                <li><Link exact='true' to='/todo'
                          className={title === 'todo' ? style.tab_day.on : style.tab_day}>Todo</Link></li>
                <li><Link exact='true' to='/diary'
                          className={title === 'diary' ? style.tab_day.on : style.tab_day}>Diary</Link></li>
                <li><Link exact='true' to='/test' className={style.tab_day}>Test</Link></li>
            </ul>
        </div>
    )
}