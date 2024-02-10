use cashflow;

select * from Users;
--用戶表
CREATE TABLE Users (
    UserID INT IDENTITY PRIMARY KEY,
    Username NVARCHAR(255) NOT NULL,
    Email NVARCHAR(255) NOT NULL UNIQUE,
    PasswordHash NVARCHAR(255),
    CreatedAt DATETIME NOT NULL DEFAULT GETDATE(),
    UpdatedAt DATETIME NOT NULL DEFAULT GETDATE()
);

--第三方登入表
CREATE TABLE UserOAuth (
    UserOAuthID INT IDENTITY PRIMARY KEY,
    UserID INT FOREIGN KEY REFERENCES Users(UserID),
    ProviderName NVARCHAR(50) NOT NULL,
    ProviderUserID NVARCHAR(255) NOT NULL,
    CreatedAt DATETIME NOT NULL DEFAULT GETDATE(),
    UpdatedAt DATETIME NOT NULL DEFAULT GETDATE()
);

--商品表
CREATE TABLE Products (
    ProductID INT IDENTITY PRIMARY KEY,
    Name NVARCHAR(255) NOT NULL,
    Description NVARCHAR(MAX),
    Price DECIMAL(18, 2) NOT NULL,
    StockQuantity INT NOT NULL,
    ImageUrl NVARCHAR(MAX),
    CreatedAt DATETIME NOT NULL DEFAULT GETDATE(),
    UpdatedAt DATETIME NOT NULL DEFAULT GETDATE()
);

--購物車表
CREATE TABLE Carts (
    CartID INT IDENTITY PRIMARY KEY,
    UserID INT FOREIGN KEY REFERENCES Users(UserID),
    CreatedAt DATETIME NOT NULL DEFAULT GETDATE(),
    UpdatedAt DATETIME NOT NULL DEFAULT GETDATE()
);

--購物車明細表
CREATE TABLE CartItems (
    CartItemID INT IDENTITY PRIMARY KEY,
    CartID INT FOREIGN KEY REFERENCES Carts(CartID),
    ProductID INT FOREIGN KEY REFERENCES Products(ProductID),
    Quantity INT NOT NULL,
    CreatedAt DATETIME NOT NULL DEFAULT GETDATE(),
    UpdatedAt DATETIME NOT NULL DEFAULT GETDATE()
);

--訂單表
CREATE TABLE Orders (
    OrderID INT IDENTITY PRIMARY KEY,
    UserID INT FOREIGN KEY REFERENCES Users(UserID),
    TotalAmount DECIMAL(18, 2) NOT NULL,
    Status NVARCHAR(50) NOT NULL,
    CreatedAt DATETIME NOT NULL DEFAULT GETDATE(),
    UpdatedAt DATETIME NOT NULL DEFAULT GETDATE()
);

--訂單明細表
CREATE TABLE OrderItems (
    OrderItemID INT IDENTITY PRIMARY KEY,
    OrderID INT FOREIGN KEY REFERENCES Orders(OrderID),
    ProductID INT FOREIGN KEY REFERENCES Products(ProductID),
    PurchasePrice DECIMAL(18, 2) NOT NULL,
    Quantity INT NOT NULL,
    CreatedAt DATETIME NOT NULL DEFAULT GETDATE(),
    UpdatedAt DATETIME NOT NULL DEFAULT GETDATE()
);

--支付信息表
CREATE TABLE Payments (
    PaymentID INT IDENTITY PRIMARY KEY,
    OrderID INT FOREIGN KEY REFERENCES Orders(OrderID),
    PaymentMethod NVARCHAR(50) NOT NULL,
    PaymentStatus NVARCHAR(50) NOT NULL,
    CreatedAt DATETIME NOT NULL DEFAULT GETDATE(),
    UpdatedAt DATETIME NOT NULL DEFAULT GETDATE()
);