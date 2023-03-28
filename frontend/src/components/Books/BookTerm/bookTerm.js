import React from "react";
import {Link} from "react-router-dom";

const bookTerm = (props) => {
    return (
        <tr>
            <td>{props.term.name}</td>
            <td>{props.term.category}</td>
            <td>{props.term.author.name}</td>
            <td>{props.term.availableCopies}</td>
            <td className={"text-right"}>
                <Link className={"btn btn-danger ml-2"}
                      onClick={() => props.onDelete(props.term.bookId)}>
                    Delete
                </Link>

            </td>
        </tr>
    )
}

export default bookTerm