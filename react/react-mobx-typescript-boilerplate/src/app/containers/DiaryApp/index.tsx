import * as React from "react";
import {TabMenu} from "app/components/Tab";

export class Diary extends React.Component {

    render() {
        return (
            <div>
                {TabMenu('diary')}
                Hello Diary
            </div>
        )
    }
}