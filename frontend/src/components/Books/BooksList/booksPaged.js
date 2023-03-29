import React, {Component} from 'react';
import BookTerm from "../BookTerm/bookTerm";
import {Link} from "react-router-dom";
import ReactPaginate from "react-paginate";

class BooksPaged extends Component {
    constructor(props) {
        super(props);
        this.state = {
            page: 0,
            size: 5
        }
    }

    render() {
        const pageCount = Math.ceil(this.props.books.length / this.state.size)
        const offset = this.state.size * this.state.page
        const nextPageOffset = offset + this.state.size
        const books = this.getBooksPage(offset, nextPageOffset)
        console.log(this.state.size)
        return (
            <div className={"container mm-4 mt-5"}>
                <h1>PAGED</h1>
                <div className={"row"}>
                    <div className={"table-responsive"}>
                        <table className={"table table-striped"}>
                            <thead>
                            <tr>
                                <th scope={"col"}>Name</th>
                                <th scope={"col"}>Category</th>
                                <th scope={"col"}>Author</th>
                                <th scope={"col"}>Available Copies</th>
                                <th></th>
                            </tr>
                            </thead>
                            <tbody>
                            {books}
                            </tbody>
                        </table>
                    </div>
                    <ReactPaginate previousLabel={"<"}
                                   nextLabel={">"}
                                   breakLabel={"..."}
                                   breakClassName="page-item"
                                   breakLinkClassName="page-link"
                                   pageClassName={"page-item"}
                                   pageLinkClassName={"page-link"}
                                   previousClassName={"page-item"}
                                   previousLinkClassName={"page-link"}
                                   nextClassName={"page-item"}
                                   nextLinkClassName={"page-link"}
                                   pageCount={pageCount}
                                   marginPagesDisplayed={2}
                                   pageRangeDisplayed={5}
                                   onPageChange={this.handlePageClick}
                                   containerClassName={"pagination m-4 justify-content-center"}
                                   activeClassName={"active"}
                                   renderOnZeroPageCount={null}/>
                    <div className="col mb-3">
                        <div className="row">
                            <div className="col-sm-12 col-md-12">
                                <Link className={"btn btn-block btn-dark"} to={"/books/add"}>Add new book</Link>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }

    getBooksPage = (offset, nextPageOffset) => {
        return this.props.books.map((term) => {
            return (
                <BookTerm term={term} onEdit={this.props.onEdit} onDelete={this.props.onDelete}
                          onTake={this.props.onTake}/>
            )
        }).filter((book, index) => {
            return index >= offset && index < nextPageOffset
        })
    }

    handlePageClick = (data) => {
        let selected = data.selected
        this.setState({
            page: selected
        })
    }
}

export default BooksPaged;
