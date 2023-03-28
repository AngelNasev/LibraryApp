import './App.css';
import React, {Component} from "react";
import {BrowserRouter as Router, Redirect, Route, Routes} from "react-router-dom";
import LibraryService from "../../repository/libraryRepository";
import Categories from "../Categories/categories";
import Header from "../Header/header";
import Books from "../Books/BooksList/books";


class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            books: [],
            categories: []
        }
    }

    render() {
        return (
            <Router>
                <Header/>
                <main>
                    <div className="container">
                        <Routes>
                            <Route path={"/"} exact element={<Books books={this.state.books} onDelete={this.deleteBook}/>}/>
                            <Route path={"/books"} exact element={<Books books={this.state.books} onDelete={this.deleteBook}/>}/>
                            <Route path={"/categories"} exact element={<Categories categories={this.state.categories}/>}/>
                        </Routes>
                    </div>
                </main>
            </Router>
        )
    }

    componentDidMount() {
        this.loadBooks();
        this.loadCategories();

    }

    loadBooks = () => {
        LibraryService.fetchBooks()
            .then((data) => {
                this.setState({
                    books: data.data
                })
            })
    }

    loadCategories = () => {
        LibraryService.fetchCategories()
            .then((data) => {
                this.setState({
                    categories:data.data
                })
            })
    }

    deleteBook = (id) => {
        LibraryService.deleteBook(id)
            .then(() => {
                this.loadBooks()
            })
    }
}

export default App;
