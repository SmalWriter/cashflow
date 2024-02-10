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
    UserOAuthID BIGINT IDENTITY PRIMARY KEY,
    ProviderName NVARCHAR(255) NOT NULL,
    ProviderUserID NVARCHAR(255) NOT NULL,
    CreatedAt DATETIME NOT NULL,
    UpdatedAt DATETIME NOT NULL,
    UserID BIGINT NOT NULL,
    FOREIGN KEY (UserID) REFERENCES Users(UserID)
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
    cartId BIGINT IDENTITY PRIMARY KEY,
    userId BIGINT NOT NULL,
    createdAt DATETIME NOT NULL,
    updatedAt DATETIME NOT NULL,
    FOREIGN KEY (userId) REFERENCES Users(UserID)
);


--購物車明細表
CREATE TABLE CartItems (
    cartItemId BIGINT IDENTITY PRIMARY KEY,
    cartId BIGINT NOT NULL,
    productId BIGINT NOT NULL,
    quantity INT NOT NULL,
    createdAt DATETIME NOT NULL,
    updatedAt DATETIME NOT NULL,
    FOREIGN KEY (cartId) REFERENCES Carts(cartId),
    FOREIGN KEY (productId) REFERENCES Products(ProductID)
);

--訂單表
CREATE TABLE Orders (
    orderId BIGINT IDENTITY PRIMARY KEY,
    userId BIGINT NOT NULL,
    totalAmount DECIMAL(18, 2) NOT NULL,
    status NVARCHAR(255) NOT NULL,
    createdAt DATETIME NOT NULL,
    updatedAt DATETIME NOT NULL,
    FOREIGN KEY (userId) REFERENCES Users(UserID)
);

--訂單明細表
CREATE TABLE OrderItems (
    orderItemId BIGINT IDENTITY PRIMARY KEY,
    orderId BIGINT NOT NULL,
    productId BIGINT NOT NULL,
    purchasePrice DECIMAL(18, 2) NOT NULL,
    quantity INT NOT NULL,
    createdAt DATETIME NOT NULL,
    updatedAt DATETIME NOT NULL,
    FOREIGN KEY (orderId) REFERENCES Orders(orderId),
    FOREIGN KEY (productId) REFERENCES Products(ProductID)
);

--支付信息表
CREATE TABLE Payments (
    paymentId BIGINT IDENTITY PRIMARY KEY,
    orderId BIGINT NOT NULL,
    paymentMethod NVARCHAR(255) NOT NULL,
    paymentStatus NVARCHAR(255) NOT NULL,
    createdAt DATETIME NOT NULL,
    updatedAt DATETIME NOT NULL,
    FOREIGN KEY (orderId) REFERENCES Orders(orderId)
);



CREATE TABLE Category (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE Product_Category (
    productId BIGINT,
    categoryId BIGINT,
    PRIMARY KEY (productId, categoryId),
    FOREIGN KEY (productId) REFERENCES Products(id),
    FOREIGN KEY (categoryId) REFERENCES Category(id)
);

CREATE TABLE Address (
    id BIGINT IDENTITY PRIMARY KEY,
    street VARCHAR(255),
    city VARCHAR(255),
    state VARCHAR(255),
    zipCode VARCHAR(255),
    userId BIGINT NOT NULL, -- 确保与Java实体类对齐，userId为非空
    FOREIGN KEY (userId) REFERENCES Users(UserID) -- 确保外键约束正确引用Users表的主键
);

CREATE TABLE Stock (
    id BIGINT PRIMARY KEY,
    quantity INT NOT NULL,
    reservedQuantity INT,
    location VARCHAR(255),
    batchNo VARCHAR(255),
    status VARCHAR(255),
    cost DECIMAL(10,2),
    value DECIMAL(10,2),
    productId BIGINT,
    FOREIGN KEY (productId) REFERENCES Products (id)
);

CREATE TABLE Review (
    id BIGINT IDENTITY PRIMARY KEY,
    content NVARCHAR(MAX), -- Assuming comments can be lengthy
    rating INT, -- Assuming a rating scale of 1 to 5
    userId BIGINT NOT NULL,
    productId BIGINT NOT NULL,
    createdTime DATETIME NOT NULL,
    FOREIGN KEY (userId) REFERENCES Users(userId),
    FOREIGN KEY (productId) REFERENCES Products(ProductID)
);

CREATE TABLE WishlistItem (
    id BIGINT IDENTITY PRIMARY KEY,
    userId BIGINT NOT NULL,
    FOREIGN KEY (userId) REFERENCES Users(UserID)
);

CREATE TABLE wishlist_product (
    wishlistItemId BIGINT NOT NULL,
    productId BIGINT NOT NULL,
    PRIMARY KEY (wishlistItemId, productId),
    FOREIGN KEY (wishlistItemId) REFERENCES WishlistItem(id),
    FOREIGN KEY (productId) REFERENCES Products(ProductID)
);

CREATE TABLE Coupon (
    id BIGINT  PRIMARY KEY,
    code VARCHAR(255) NOT NULL UNIQUE,
    discount DECIMAL(10, 2) NOT NULL,
    validFrom DATETIME NOT NULL,
    validTo DATETIME NOT NULL,
    userId BIGINT,
    FOREIGN KEY (userId) REFERENCES Users(id)
);

CREATE TABLE ProductRecommendation (
    RecommendationID INT IDENTITY PRIMARY KEY,
    ProductID INT NOT NULL,
    RecommendedProductID INT NOT NULL,
    FOREIGN KEY (ProductID) REFERENCES Products(ProductID),
    FOREIGN KEY (RecommendedProductID) REFERENCES Products(ProductID)
);

-- 产品和促销活动的联结表
CREATE TABLE promotion_product (
    promotionId BIGINT,
    productId BIGINT,
    PRIMARY KEY (promotionId, productId),
    FOREIGN KEY (promotionId) REFERENCES Promotion(promotionId),
    FOREIGN KEY (productId) REFERENCES Product(productId)
);

-- 用户和促销活动的联结表
CREATE TABLE promotion_user (
    promotionId BIGINT,
    userId BIGINT,
    PRIMARY KEY (promotionId, userId),
    FOREIGN KEY (promotionId) REFERENCES Promotion(promotionId),
    FOREIGN KEY (userId) REFERENCES Users(userId)
);

-- 类别和促销活动的联结表
CREATE TABLE promotion_category (
    promotionId BIGINT,
    categoryId BIGINT,
    PRIMARY KEY (promotionId, categoryId),
    FOREIGN KEY (promotionId) REFERENCES Promotion(promotionId),
    FOREIGN KEY (categoryId) REFERENCES Category(categoryId)
);


--用戶活動日誌
CREATE TABLE UserActivityLog (
    LogID INT IDENTITY PRIMARY KEY,
    UserID INT NOT NULL,
    ActivityType NVARCHAR(255) NOT NULL,
    ActivityDate DATETIME NOT NULL,
    Description NVARCHAR(MAX),
    FOREIGN KEY (UserID) REFERENCES Users(UserID)
);

--用戶間的社交功能
CREATE TABLE Follow (
    FollowID INT IDENTITY PRIMARY KEY,
    FollowerID INT NOT NULL,
    FollowingID INT NOT NULL,
    FollowDate DATETIME,
    FOREIGN KEY (FollowerID) REFERENCES Users(UserID),
    FOREIGN KEY (FollowingID) REFERENCES Users(UserID)
);

--SKU管理
--SKU（庫存單位）管理是電子商務平台特別關注的一個方面，它涉及到產品的多個變體，例如大小、顏色等。
CREATE TABLE SKU (
    id BIGINT IDENTITY PRIMARY KEY,
    productId BIGINT NOT NULL,
    skuCode NVARCHAR(255) NOT NULL,
    price DECIMAL(18, 2) NOT NULL,
    stockQuantity INT NOT NULL,
    attributes NVARCHAR(MAX), -- JSON格式的字符串，存储SKU的额外属性，如颜色、尺寸等。
    FOREIGN KEY (productId) REFERENCES Products(ProductID)
);