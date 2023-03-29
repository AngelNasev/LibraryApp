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
                <Link className={"btn btn-success"}
                      onClick={() => props.onTake(props.term.bookId)}>
                    Mark As Taken
                </Link>
                <Link className={"btn btn-info mx-2"}
                      onClick={() => props.onEdit(props.term.bookId)}
                      to={`/books/edit/${props.term.bookId}`}>
                    Edit
                </Link>
                <Link className={"btn btn-danger"}
                      onClick={() => props.onDelete(props.term.bookId)}>
                    Delete
                </Link>

            </td>
        </tr>
    )
}

export default bookTerm